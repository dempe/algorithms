package com.project.euler.problems;

import com.project.euler.AbstractBaseResult;
import com.project.euler.Problem;
import com.project.euler.Result;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.project.euler.util.Math.sumIntegersInRange;

@Lazy
@Component
public class Problem0006 implements Problem {
    private static final int MAX = 100;

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static class ResultImpl extends AbstractBaseResult {
        @Override
        public Number naively() {
            final int squareOfSums = sumIntegersInRange(0, MAX) * sumIntegersInRange(0, MAX);

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
