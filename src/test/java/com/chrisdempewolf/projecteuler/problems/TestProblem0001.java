package com.chrisdempewolf.projecteuler.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.chrisdempewolf.projecteuler.Problem;
import com.chrisdempewolf.projecteuler.TestProblem;
import org.junit.jupiter.api.Test;

public class TestProblem0001 implements TestProblem {
    private static final int ANSWER = 233168;

    private final Problem problem = new Problem0001();

    @Test
    @Override
    public void testNaively() {
        assertEquals(ANSWER, problem.solve().naively().longValue());
    }

    @Test
    @Override
    public void testNonNaively() {
        assertEquals(ANSWER, problem.solve().nonNaively().longValue());
    }
}
