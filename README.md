# Coding Exercises

Java coding exercises and a dependency-cycle checker, built with Gradle.

## Requirements

JDK 17 or newer. The Gradle Wrapper downloads and runs the pinned Gradle version, so a separate Gradle installation is not needed.

## Build and run

```sh
./gradlew build
./gradlew run
```

Application code is under `src/main/java/com/github/weitianyi1993/coding`. LeetCode solutions live in the `leetcode` package, and dependency graph utilities live in the `dependency` package.
