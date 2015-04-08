package com.project.euler.problems;

import com.project.euler.Problem;
import com.project.euler.TestProblem;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem0007 implements TestProblem {
    private static final long ANSWER = 104743;

    private final Problem problem = new Problem0007();

    @Test
    @Override
    public void testNaive() {
        assertEquals(ANSWER, problem.solve().naively().longValue());
    }

    @Ignore
    @Override
    public void testNonNaive() {
        assertEquals(ANSWER, problem.solve().nonNaively().longValue());
    }
}