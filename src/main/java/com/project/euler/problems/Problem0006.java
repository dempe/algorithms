package com.project.euler.problems;

import com.project.euler.AbstractBaseResult;
import com.project.euler.Problem;
import com.project.euler.Result;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Problem0006 implements Problem {

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static class ResultImpl extends AbstractBaseResult {
        @Override
        public Number naively() {
            return null;
        }

        @Override
        public Number nonNaively() {
            return null;
        }
    }

}
