package com.project.euler.problems;

import com.project.euler.Problem;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem0003 implements com.project.euler.problems.ProblemTest {
    private static final long ANSWER = 600851475143L;

    private final Problem problem = new Problem0003();

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