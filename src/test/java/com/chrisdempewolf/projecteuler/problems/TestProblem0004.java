package com.chrisdempewolf.projecteuler.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.chrisdempewolf.projecteuler.TestProblem;
import com.chrisdempewolf.projecteuler.Problem;
import org.junit.jupiter.api.Test;

public class TestProblem0004 implements TestProblem {
    private static final long ANSWER = 906609;

    private final Problem problem = new Problem0004();

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