package com.github.weitianyi1993.coding.dependency.resolver;

import java.util.*;

public class VersionRangeSolver {
    private final Map<String, List<Version>> availableVersions;

    // 组件 -> 选定版本 -> (依赖组件 -> 约束区间)
    private final Map<String, Map<Version, Map<String, VersionRange>>> dependencies;

    private final Set<String> memo = new HashSet<>();

    private String firstConflict = null;

    public VersionRangeSolver(Map< String, List<Version>> availableVersions, Map<String, Map<Version, Map<String, VersionRange>>> dependencies) {
        this.availableVersions = availableVersions;
        this.dependencies = dependencies;
    }

    public Map<String, Version> solve() {
        List<String> variables = new ArrayList<>(availableVersions.keySet());
        Map<String, Version> assignment = new LinkedHashMap<>();
        Map<String, VersionRange> constraints = new HashMap<>();

        for (String var : variables) {
            constraints.put(var, VersionRange.any());
        }

        boolean success = backtrack(assignment, constraints, variables);
        return success ? assignment : null;
    }

    public String getFirstConflict() {
        return firstConflict;
    }

    private boolean backtrack(Map<String, Version> assignment,
                              Map<String, VersionRange> constraints,
                              List<String> variables) {
        // 1. 递归基：所有组件分配完成
        if (assignment.size() == variables.size()) {
            return true;
        }

        // 记忆化剪枝：如果当前状态之前已被证明无解，直接剪枝
        String stateKey = computeStateKey(assignment, constraints);
        if (memo.contains(stateKey)) {
            return false;
        }

        // 选取下一个未分配变量
        String var = null;
        for (String v : variables) {
            if (!assignment.containsKey(v)) {
                var = v;
                break;
            }
        }

        List<Version> candidates = availableVersions.getOrDefault(var, Collections.emptyList());

        for (Version ver : candidates) {
            if (!constraints.get(var).contains(ver)) {
                continue;
            }

            // 2. 前向检查 (Forward Checking)：传播新约束
            Map<String, VersionRange> nextConstraints = new HashMap<>(constraints);
            boolean conflict = false;

            Map<String, VersionRange> rules = dependencies
                    .getOrDefault(var, Collections.emptyMap())
                    .getOrDefault(ver, Collections.emptyMap());

            for (Map.Entry<String, VersionRange> entry : rules.entrySet()) {
                String dep = entry.getKey();
                VersionRange ruleRange = entry.getValue();

                VersionRange merged = nextConstraints.get(dep).intersect(ruleRange);

                // 冲突 A：区间交集为空
                if (merged == null) {
                    if (firstConflict == null) {
                        firstConflict = String.format("冲突：%s@%s 依赖 %s 满足 %s，与当前约束 %s 互斥",
                                var, ver, dep, ruleRange, nextConstraints.get(dep));
                    }
                    conflict = true;
                    break;
                }
                nextConstraints.put(dep, merged);

                // 冲突 B：未分配依赖项的可用版本被全部排除
                if (!assignment.containsKey(dep)) {
                    boolean hasValid = false;
                    for (Version cand : availableVersions.getOrDefault(dep, Collections.emptyList())) {
                        if (merged.contains(cand)) {
                            hasValid = true;
                            break;
                        }
                    }
                    if (!hasValid) {
                        if (firstConflict == null) {
                            firstConflict = String.format("剪枝：%s@%s 约束后，组件 %s 无可用候选版本",
                                    var, ver, dep);
                        }
                        conflict = true;
                        break;
                    }
                }
            }

            if (conflict) {
                continue;
            }

            // 3. 递归推进
            assignment.put(var, ver);
            if (backtrack(assignment, nextConstraints, variables)) {
                return true;
            }

            // 回溯复原
            assignment.remove(var);
        }

        memo.add(stateKey);
        return false;
    }

    private String computeStateKey(Map<String, Version> assignment, Map<String, VersionRange> constraints) {
        StringBuilder sb = new StringBuilder();
        assignment.forEach((k, v) -> sb.append(k).append("=").append(v).append(";"));
        sb.append("|");
        constraints.forEach((k, v) -> sb.append(k).append(":").append(v).append(";"));
        return sb.toString();
    }
}
