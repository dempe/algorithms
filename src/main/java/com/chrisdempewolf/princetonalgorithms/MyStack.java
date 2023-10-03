package com.chrisdempewolf.princetonalgorithms;

public class MyStack<T> extends MyLinkedList<T> {

    public static void main(String[] args) {
        final MyStack<Integer> ms = new MyStack<>();

        ms.print()
          .push(2)
          .print()
          .pop();

        ms.push(5)
          .push(4)
          .push(3)
          .push(2)
          .push(1)
          .print();
    }

    @Override
    public long size() {
        return super.size();
    }

    public MyStack<T> push(T element) {
        super.add(element);
        return this;
    }

    public T pop() {
        final long lastIndex = super.size() - 1;
        final T    lastItem  = super.get(lastIndex);
        super.remove(lastIndex);
        return lastItem;
    }

    @Override
    public MyStack<T> print() {
        super.print();
        return this;
    }
}
