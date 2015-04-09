package com.project.euler.problems;

import com.project.euler.Problem;
import com.project.euler.TestProblem;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem0003 implements TestProblem {
    private static final long ANSWER = 600851475143L;

    private final Problem problem = new Problem0003();

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