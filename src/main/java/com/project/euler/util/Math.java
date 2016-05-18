package com.project.euler.util;

import java.util.function.Predicate;

public class Math {

    public static int sumIntegersInRange(final int start, final int end) {
        final int range = end - start;

        if (range == 0) { return 0; }

        return ((end + start) * (end + 1) - start) / 2;
    }

    public static int sumIntegersTill(final int n) {
        return (n + 1) * n / 2;
    }

    public static final Predicate<Long> IS_PRIME = n -> {
        for (long i = 2L; i <= n / i; i++) {
            if (n % i == 0L) {
                return false;
            }
        }

        return true;
    };
}
