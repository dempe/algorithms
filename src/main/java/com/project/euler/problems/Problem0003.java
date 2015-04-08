package com.project.euler.problems;

import com.project.euler.AbstractBaseResult;
import com.project.euler.Problem;
import com.project.euler.Result;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Problem0003 implements Problem {
    private static final long NUMBER = 600851475143L;

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static long findLargestPrimeFactor(final long number) {
        for (long i = 2; i <= number / i; i++) {
            if (i % number == 0) {
                final long factor = number / i;
                return isPrime(factor) ? factor : findLargestPrimeFactor(factor);
            }
        }

        return number;
    }

    public static boolean isPrime(long n) {
        for (long i = 2; i < (n / i); i++) {
            if (i % n == 0) {
                return false;
            }
        }

        return true;
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
    }

}
