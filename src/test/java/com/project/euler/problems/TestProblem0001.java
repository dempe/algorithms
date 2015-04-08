package com.project.euler.problems;

import com.project.euler.Problem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem0001 implements com.project.euler.problems.ProblemTest {
    private static final int ANSWER = 233168;

    private final Problem problem = new Problem0001();

    @Test
    @Override
    public void testNaive() {
        assertEquals(ANSWER, problem.solve().naively().longValue());
    }

    @Test
    @Override
    public void testNonNaive() {
        assertEquals(ANSWER, problem.solve().nonNaively().longValue());
    }
}
