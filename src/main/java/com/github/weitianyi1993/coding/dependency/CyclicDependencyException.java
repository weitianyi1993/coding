package com.github.weitianyi1993.coding.dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CyclicDependencyException extends RuntimeException {
    private final List<List<String>> cycles;

    public CyclicDependencyException(List<List<String>> cycles) {
        super("Detected cyclic dependencies in modules: " + cycles);
        this.cycles = new ArrayList<>();
        for (List<String> cycle : cycles) {
            this.cycles.add(new ArrayList<>(cycle));
        }
    }

    public List<List<String>> getCycles() {
        return Collections.unmodifiableList(cycles);
    }
}
