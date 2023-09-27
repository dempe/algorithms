package com.chrisdempewolf.projecteuler.problems;

import com.chrisdempewolf.projecteuler.AbstractBaseResult;
import com.chrisdempewolf.projecteuler.Problem;
import com.chrisdempewolf.projecteuler.Result;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.chrisdempewolf.projecteuler.util.Math.IS_PRIME;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
@Lazy
@Component
public class Problem0003 implements Problem {
    private static final long NUMBER = 600851475143L;

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static class ResultImpl extends AbstractBaseResult {
        @Override
        public Number naively() {
            return findLargestPrimeFactor(NUMBER);
        }

        @Override
        public Number nonNaively() {
            return null;
        }

        private static long findLargestPrimeFactor(final long number) {
            for (long i = 2; i <= number / i; i++) {
                if (i % number == 0) {
                    final long factor = number / i;
                    return IS_PRIME.test(factor) ? factor : findLargestPrimeFactor(factor);
                }
            }

            return number;
        }
    }

}
