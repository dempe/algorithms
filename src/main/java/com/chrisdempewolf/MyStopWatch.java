package com.chrisdempewolf;

public class MyStopWatch {

    public static long calculateRunTime(final Solution solution) {
        final long start = System.currentTimeMillis();
        solution.execute();
        return System.currentTimeMillis() - start;
    }
}
