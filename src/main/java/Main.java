import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Three sum: " + new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("Subsets: " + new Subset().subsets(new int[]{1, 2, 3}));

        Map<String, List<String>> dependencies = new HashMap<>();
        dependencies.put("app", Arrays.asList("core", "logging"));
        dependencies.put("core", Collections.singletonList("utils"));
        dependencies.put("logging", Collections.singletonList("utils"));
        dependencies.put("utils", Collections.emptyList());
        new TarjanCyclicDependencyChecker(dependencies).check("app");
        System.out.println("Dependency graph: no cycles");
    }
}
