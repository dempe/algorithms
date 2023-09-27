package com.chrisdempewolf.projecteuler.problems;

import com.chrisdempewolf.projecteuler.TestProblem;
import com.chrisdempewolf.projecteuler.Problem;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem0007 implements TestProblem {
    private static final long ANSWER = 104743;

    private final Problem problem = new Problem0007();

    @Test
    @Override
    public void testNaively() {
        assertEquals(ANSWER, problem.solve().naively().longValue());
    }

    @Ignore
    @Override
    public void testNonNaively() {
        assertEquals(ANSWER, problem.solve().nonNaively().longValue());
    }
}