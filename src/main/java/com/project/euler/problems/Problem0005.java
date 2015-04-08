package com.project.euler.problems;

import com.project.euler.AbstractBaseResult;
import com.project.euler.Problem;
import com.project.euler.Result;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Problem0005 implements Problem {
    private static final int NUMBER = 20;

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static boolean isDivisibleByNumbersInRange(final int n) {
        for (int i = 2; i <= NUMBER; i++) {
            if (n % i != 0) { return false; }
        }

        return true;
    }

    private static class ResultImpl extends AbstractBaseResult {
        @Override
        public Number naively() {
            for (int i = NUMBER; i < Integer.MAX_VALUE; i++) {
                if (isDivisibleByNumbersInRange(i)) { return i; }
            }

            return 0;
        }

        @Override
        public Number nonNaively() {
            return null;
        }
    }

}
