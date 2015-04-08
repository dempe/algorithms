package com.project.euler.util;

public class Math {

    public static int sumIntegersInRange(final int start, final int end) {
        final int range = end - start;

        if (range == 0) { return 0; }

        return ((end + start) * (end + 1) - start) / 2;
    }

    public static int sumIntegersTill(final int n) {
        return (n + 1) * n / 2;
    }

    public static boolean isNegative(final int n) {
        return n < 0;
    }

    public static boolean isPrime(final long n) {
        for (long i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
