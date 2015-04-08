package com.project.euler.problems;

import com.project.euler.Problem;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem0002 implements ProblemTest {
    private static final long ANSWER = 4613732;

    private final Problem problem = new Problem0002();

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