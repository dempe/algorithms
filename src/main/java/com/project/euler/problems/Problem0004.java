package com.project.euler.problems;

import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.FastList;
import com.project.euler.AbstractBaseResult;
import com.project.euler.Problem;
import com.project.euler.Result;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Lazy
@Component
public class Problem0004 implements Problem {
    private static final int MAX = 999;
    private static final int MIN = 100;

    @Override
    public Result solve() {
        return new ResultImpl();
    }

    private static boolean isPalindrome(final String str) {
        if (isBlank(str)) { return true; }

        final int len = str.length();
        if (len == 1) { return true; }

        char a = str.charAt(0);
        char b = str.charAt(len - 1);

        return a != b ? false : isPalindrome(str.substring(1, len - 1));
    }

    private static class ResultImpl extends AbstractBaseResult {
        @Override
        public Number naively() {
            final MutableList<Integer> products = FastList.newList();

            for (int i = MAX; i > MIN; i--) {
                for (int j = MAX; j >= i; j--) {
                    products.add(i * j);
                }
            }

            for (final Integer product : products.sortThis().reverseThis()) {
                if (isPalindrome(product.toString())) { return product; }
            }

            return 0;
        }

        @Override
        public Number nonNaively() {
            return null;
        }
    }
}
