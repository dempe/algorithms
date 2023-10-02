package com.chrisdempewolf.projecteuler.problems;

import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.FastList;
import com.chrisdempewolf.projecteuler.AbstractBaseResult;
import com.chrisdempewolf.projecteuler.Problem;
import com.chrisdempewolf.projecteuler.Result;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem0004 implements Problem {
    private static final int MAX = 999;
    private static final int MIN = 100;

    @Override
    public Result solve() {
        return new ResultImpl();
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

        private static boolean isPalindrome(final String str) {
            if (isBlank(str)) { return true; }

            final int len = str.length();
            if (len == 1) { return true; }

            final int firstChar = (int) str.charAt(0);
            final int lastChar  = (int) str.charAt(len - 1);

            return firstChar == lastChar && isPalindrome(str.substring(1, len - 1));
        }
    }
}
