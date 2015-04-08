package com.project.euler;

public abstract class AbstractBaseResult implements Result {

    @Override
    public abstract Number naively();

    @Override
    public abstract Number nonNaively();

    @Override
    public Number asQuicklyAsPossible() {
        final Number nonNaiveSolution = nonNaively();

        return nonNaiveSolution != null ? nonNaiveSolution : naively();
    }

    @Override
    public Number disregard() {
        return null;
    }

    @Override
    public String toString() {
        final Number nonNaiveSolution = nonNaively();

        if (nonNaiveSolution != null) { return nonNaiveSolution.toString(); }

        final Number naiveSolution = naively();
        return naiveSolution == null ? "?" : naiveSolution.toString();
    }
}
