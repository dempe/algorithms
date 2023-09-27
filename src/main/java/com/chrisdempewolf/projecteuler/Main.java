package com.chrisdempewolf.projecteuler;

import com.chrisdempewolf.projecteuler.configuration.ApplicationContextLoader;
import com.chrisdempewolf.projecteuler.configuration.Configuration;

import java.util.AbstractMap;
import java.util.Map;
import java.util.function.Function;

public class Main {
    private static final Function<Map.Entry<String, Problem>, Map.Entry<String, Number>> PROBLEM_SOLVER =
            problemEntry -> new AbstractMap.SimpleEntry<>(problemEntry.getKey(), problemEntry.getValue().solve().asQuicklyAsPossible());

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();

        ApplicationContextLoader.loadConfigurations(Configuration.class)
                                .getBeansOfType(Problem.class)
                                .entrySet()
                                .stream()
                                .map(PROBLEM_SOLVER)
                                .forEach(p -> System.out.println(p.getKey() + ":  " + p.getValue()));

        final long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("Total execution time:  " + executionTime);
    }
}
