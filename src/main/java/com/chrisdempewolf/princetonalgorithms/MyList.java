package com.chrisdempewolf.princetonalgorithms;

public interface MyList<T> {
    long size();
    MyList<T> add(T element);
    MyList<T> remove(long i);
    T get(long i);
    MyList<T> print();
}
