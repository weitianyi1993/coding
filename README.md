# Coding exercises

This repository keeps the existing `leetcode/` and `dependency-management/` folders. The Gradle build compiles those classes together with the runnable entry point in `src/main/java/`.

Requirements: JDK 17 or newer and Gradle.

```sh
gradle run
gradle build
```

`Main` runs a few example algorithms and checks a sample dependency graph. Individual exercise classes remain package-private and can be called from `Main` or another class in the default package.
