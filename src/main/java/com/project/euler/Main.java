package com.project.euler;

import com.project.euler.configuration.ApplicationContextLoader;
import com.project.euler.configuration.Configuration;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();

        ApplicationContextLoader.loadConfigurations(Configuration.class)
                                .getBeansOfType(Problem.class)
                                .entrySet()
                                .parallelStream()
                                .map(ProblemSolver::new)
                                .forEach(p -> p.run());

        final long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("Total execution time:  " + executionTime);
    }

    private static class ProblemSolver implements Runnable {
        private final Map.Entry<String, Problem> problem;

        private ProblemSolver(Map.Entry<String, Problem> problem) {
            this.problem = problem;
        }

        @Override
        public void run() {
            System.out.println(problem.getKey() + ":  " + problem.getValue().solve().asQuicklyAsPossible());
        }
    }
}
