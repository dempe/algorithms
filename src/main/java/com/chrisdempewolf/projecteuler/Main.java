package com.chrisdempewolf.projecteuler;

import com.chrisdempewolf.projecteuler.problems.Problem0001;
import com.chrisdempewolf.projecteuler.problems.Problem0002;
import com.chrisdempewolf.projecteuler.problems.Problem0003;
import com.chrisdempewolf.projecteuler.problems.Problem0004;
import com.chrisdempewolf.projecteuler.problems.Problem0005;
import com.chrisdempewolf.projecteuler.problems.Problem0006;
import com.chrisdempewolf.projecteuler.problems.Problem0007;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final List<Problem> PROBLEMS = Arrays.asList(new Problem0001(),
                                                                new Problem0002(),
                                                                new Problem0003(),
                                                                new Problem0004(),
                                                                new Problem0005(),
                                                                new Problem0006(),
                                                                new Problem0007());

    public static void main(String[] args) {
        for (final Problem problem : PROBLEMS) {
            final String name = problem.getClass().getName();
            final long start = System.currentTimeMillis();
            final Number answer = problem.solve().asQuicklyAsPossible();
            final long runtime = System.currentTimeMillis() - start;

            System.out.println(name + " = " + answer + ". Solved in " + runtime + " millis.");
        }
    }
}
