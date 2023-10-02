package com.chrisdempewolf.projecteuler.problems;

import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.factory.Lists;
import com.chrisdempewolf.projecteuler.AbstractBaseResult;
import com.chrisdempewolf.projecteuler.Problem;
import com.chrisdempewolf.projecteuler.Result;

import static com.chrisdempewolf.projecteuler.util.Math.IS_PRIME;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */
public class Problem0007 implements Problem {
    private static final int MAX = 10001;

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static class ResultImpl extends AbstractBaseResult {
        @Override
        public Number naively() {
            final MutableList<Long> primes = Lists.mutable.of(2L, 3L);

            for (long i = 4; i < Integer.MAX_VALUE && primes.size() < MAX; i++) {
                if (IS_PRIME.test(i)) {
                    primes.add(i);
                }
            }

            return primes.getLast();
        }

        @Override
        public Number nonNaively() {
            return null;
        }
    }
}
