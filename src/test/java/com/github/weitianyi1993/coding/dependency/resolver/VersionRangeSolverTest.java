package com.github.weitianyi1993.coding.dependency.resolver;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VersionRangeSolverTest {

    @Test
    void returnsNoSolutionWhenDiamondDependenciesRequireDifferentCommonVersions() {
        Version app = new Version("1.0");
        Version libA = new Version("1.0");
        Version libB = new Version("1.0");

        Map<String, List<Version>> availableVersions = new LinkedHashMap<>();
        availableVersions.put("App", List.of(app));
        availableVersions.put("LibA", List.of(libA));
        availableVersions.put("LibB", List.of(libB));
        availableVersions.put("CommonLib", Arrays.asList(new Version("1.0"), new Version("2.0")));

        Map<String, Map<Version, Map<String, VersionRange>>> dependencies = new LinkedHashMap<>();
        dependencies.put("App", rulesFor(app, Map.of(
                "LibA", exact("1.0"),
                "LibB", exact("1.0")
        )));
        dependencies.put("LibA", rulesFor(libA, Map.of("CommonLib", exact("2.0"))));
        dependencies.put("LibB", rulesFor(libB, Map.of("CommonLib", exact("1.0"))));

        VersionRangeSolver solver = new VersionRangeSolver(availableVersions, dependencies);
        Map<String, Version> solution = solver.solve();
        String conflict = solver.getFirstConflict();

        assertAll(
                () -> assertNull(solution, "The incompatible CommonLib requirements must make the graph unsatisfiable"),
                () -> assertNotNull(conflict, "The solver should retain the first detected conflict"),
                () -> assertTrue(conflict.contains("LibB@1.0"), conflict),
                () -> assertTrue(conflict.contains("CommonLib"), conflict),
                () -> assertTrue(conflict.contains("[1.0, 1.0]"), conflict),
                () -> assertTrue(conflict.contains("[2.0, 2.0]"), conflict),
                () -> assertFalse(conflict.contains("剪枝："), "This case should fail on an empty range intersection")
        );
    }

    private static Map<Version, Map<String, VersionRange>> rulesFor(
            Version version,
            Map<String, VersionRange> requirements
    ) {
        Map<Version, Map<String, VersionRange>> rules = new LinkedHashMap<>();
        rules.put(version, requirements);
        return rules;
    }

    private static VersionRange exact(String version) {
        Version exactVersion = new Version(version);
        return new VersionRange(exactVersion, true, exactVersion, true);
    }
}
