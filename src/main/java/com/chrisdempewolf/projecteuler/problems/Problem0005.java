package com.chrisdempewolf.projecteuler.problems;

import com.chrisdempewolf.projecteuler.AbstractBaseResult;
import com.chrisdempewolf.projecteuler.Problem;
import com.chrisdempewolf.projecteuler.Result;

/**
 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

 What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem0005 implements Problem {
    private static final int TARGET_NUMBER = 20;

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static class ResultImpl extends AbstractBaseResult {
        @Override
        public Number naively() {
            for (int i = TARGET_NUMBER; i < Integer.MAX_VALUE; i++) {
                if (isDivisibleByNumbersInRange(i)) { return i; }
            }

            return 0;
        }

        @Override
        public Number nonNaively() {
            return null;
        }

        private static boolean isDivisibleByNumbersInRange(final int n) {
            for (int i = 2; i <= TARGET_NUMBER; i++) {
                if (n % i != 0) { return false; }
            }

            return true;
        }
    }

}
