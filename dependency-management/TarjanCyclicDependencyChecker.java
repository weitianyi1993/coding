import java.util.*;

// Dependency checker
// 把它想成一个类似审讯犯人的算法。对任何一个depednendcy，先关押到房间里（stack）
// 然后“审讯”它的dependency。如果dependency有了环形依赖会被留在栈里，如果没有则不会留在栈里。
class TarjanCyclicDependencyChecker {
    private Map<String, List<String>> graph;
    private int timestamp;
    private Map<String, Integer> dfn = new HashMap<>();
    private Map<String, Integer> low = new HashMap<>();

    private Deque<String> stack = new ArrayDeque<>();
    private Set<String> inStack = new HashSet<>();

    private List<List<String>> allCycles = new ArrayList<>();

    public TarjanCyclicDependencyChecker(Map<String, List<String>> graph) {
        this.graph = graph;
    }

    public void check(String dependency) {
        dfs(dependency);
    }

    private void dfs(String u) {
        dfn.put(u, timestamp);
        low.put(u, timestamp);

        timestamp++;
        stack.push(u);
        inStack.add(u);

        List<String> neighbors = graph.getOrDefault(u, Collections.emptyList());
        for (String v : neighbors) {
            if (!dfn.containsKey(v)) {
                dfs(v);
            }
            low.put(u, Math.min(low.get(u), dfn.get(v)));
        }

        if (low.get(u).equals(dfn.get(u))) {
            List<String> scc = new ArrayList<>();
            String curr;

            do {
                curr = stack.pop();
                inStack.remove(curr);
                scc.add(curr);
            } while (!curr.equals(u));

            if (scc.size() > 1 || (scc.size() == 1 && neighbors.contains(u))) {
                allCycles.add(scc);
                throw new CyclicDependencyException(allCycles);
            }
        }
    }
}

class CyclicDependencyException extends RuntimeException {
    private final List<List<String>> cycles;
    public CyclicDependencyException(List<List<String>> cycles ) {
        super("Detected cyclic dependencies in modules: " + cycles);
        this.cycles = cycles;
    }

    public List<List<String>> getCycles() {
        return cycles;
    }
}

