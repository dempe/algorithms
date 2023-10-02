package com.chrisdempewolf.projecteuler.problems;

import com.chrisdempewolf.projecteuler.AbstractBaseResult;
import com.chrisdempewolf.projecteuler.Problem;
import com.chrisdempewolf.projecteuler.Result;

import static com.chrisdempewolf.projecteuler.util.Math.sumIntegersInRange;

/**
 *
 The sum of the squares of the first ten natural numbers is,
 1^2 + 2^2 + ... + 10^2 = 385

 The square of the sum of the first ten natural numbers is,
 (1 + 2 + ... + 10)^2 = 55^2 = 3025

 Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

 Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem0006 implements Problem {
    private static final int MAX = 100;

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static class ResultImpl extends AbstractBaseResult {
        @Override
        public Number naively() {
            final int sum = sumIntegersInRange(0, MAX);
            final int squareOfSums = sum * sum;

            int sumOfSquares = 0;
            for (int i = 0; i <= MAX; i++) {
                sumOfSquares += i * i;
            }

            return squareOfSums - sumOfSquares;
        }

        @Override
        public Number nonNaively() {
            return null;
        }
    }

}
