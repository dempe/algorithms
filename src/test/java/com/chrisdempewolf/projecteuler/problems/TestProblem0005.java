package com.chrisdempewolf.projecteuler.problems;

import com.chrisdempewolf.projecteuler.Problem;
import com.chrisdempewolf.projecteuler.TestProblem;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem0005 implements TestProblem {
    private static final long ANSWER = 232792560;

    private final Problem problem = new Problem0005();

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