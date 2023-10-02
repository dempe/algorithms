package com.chrisdempewolf.projecteuler.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.chrisdempewolf.projecteuler.Problem;
import com.chrisdempewolf.projecteuler.TestProblem;
import org.junit.jupiter.api.Test;


public class TestProblem0002 implements TestProblem {
    private static final long ANSWER = 4613732;

    private final Problem problem = new Problem0002();

    @Test
    @Override
    public void testNaively() {
        assertEquals(ANSWER, problem.solve().naively().longValue());
    }

    @Override
    public void testNonNaively() {
        assertEquals(ANSWER, problem.solve().nonNaively().longValue());
    }
}