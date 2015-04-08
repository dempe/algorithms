package com.project.euler.problems;

import com.project.euler.Problem;
import com.project.euler.TestProblem;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem0004 implements TestProblem {
    private static final long ANSWER = 906609;

    private final Problem problem = new Problem0004();

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