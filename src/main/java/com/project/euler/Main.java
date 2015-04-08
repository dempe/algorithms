package com.project.euler;

import com.gs.collections.api.block.function.Function;
import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.FastList;
import com.project.euler.configuration.ApplicationContextLoader;
import com.project.euler.configuration.Configuration;
import org.springframework.context.ApplicationContext;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SIZE = 10;
    private static final Function<Map.Entry<String, Problem>, ProblemSolver> PROBLEM_SOLVER_FUNCTION = new Function<Map.Entry<String, Problem>, ProblemSolver>() {
        @Override
        public ProblemSolver valueOf(Map.Entry<String, Problem> problemEntry) {
            return new ProblemSolver(problemEntry);
        }
    };

    public static void main(String[] args) {
        final ApplicationContext applicationContext = ApplicationContextLoader.loadConfigurations(Configuration.class);
        final MutableList<ProblemSolver> problemSolvers = FastList.newList(applicationContext.getBeansOfType(Problem.class).entrySet())
                                                                  .collect(PROBLEM_SOLVER_FUNCTION);
        final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (final ProblemSolver problemSolver : problemSolvers) {
            executorService.execute(problemSolver);
        }

        executorService.shutdown();
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
