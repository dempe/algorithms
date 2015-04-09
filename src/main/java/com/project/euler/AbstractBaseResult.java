package com.project.euler;

public abstract class AbstractBaseResult implements Result {

    @Override
    public String toString() {
        final Number nonNaiveSolution = nonNaively();

        if (nonNaiveSolution != null) { return nonNaiveSolution.toString(); }

        final Number naiveSolution = naively();
        return naiveSolution == null ? "?" : naiveSolution.toString();
    }

}
