package com.project.euler.problems;

import com.gs.collections.api.block.predicate.Predicate;
import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.block.function.AddFunction;
import com.project.euler.AbstractBaseResult;
import com.project.euler.Problem;
import com.project.euler.Result;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.gs.collections.impl.list.mutable.FastList.newList;

@Lazy
@Component
public class Problem0002 implements Problem {
    private static final int START_1 = 1;
    private static final int START_2 = 2;
    private static final int MAX = 4000000;
    private static final Predicate<Integer> IS_EVEN = new Predicate<Integer>() {
        @Override
        public boolean accept(Integer i) {
            return i % 2 == 0;
        }
    };

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static class ResultImpl extends AbstractBaseResult {
        @Override
        public Number naively() {
            final MutableList<Integer> fibs = newList();
            int prevPrev = START_1;
            int prev = START_2;
            int next;

            while ((next = prevPrev + prev) <= MAX) {
                fibs.add(next);
                prevPrev = prev;
                prev = next;
            }

            return fibs.select(IS_EVEN).injectInto(START_2, AddFunction.INTEGER);
        }

        @Override
        public Number nonNaively() {
            return null;
        }
    }

}
