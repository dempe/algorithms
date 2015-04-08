package com.project.euler.problems;

import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.factory.Lists;
import com.project.euler.AbstractBaseResult;
import com.project.euler.Problem;
import com.project.euler.Result;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.project.euler.util.Math.isPrime;

@Lazy
@Component
public class Problem0007 implements Problem {
    private static final int MAX = 10001;

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static class ResultImpl extends AbstractBaseResult {
        @Override
        public Number naively() {
            final MutableList<Integer> primes = Lists.mutable.of(2, 3);

            for (int i = 4; i < Integer.MAX_VALUE && primes.size() < MAX; i++) {
                if (isPrime(i)) {
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
