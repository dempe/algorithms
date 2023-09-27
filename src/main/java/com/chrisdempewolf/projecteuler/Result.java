package com.chrisdempewolf.projecteuler;

public interface Result {
    Number naively();
    Number nonNaively();

    default Number asQuicklyAsPossible() {
        final Number nonNaiveSolution = nonNaively();

        return nonNaiveSolution != null ? nonNaiveSolution : naively();
    }

    default Number disregard() {
        return null;
    }

}
