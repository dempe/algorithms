package com.chrisdempewolf.princetonalgorithms;

public class MyLinkedList<T> implements MyList<T> {

    public static void main(String[] args) {
        final MyLinkedList<Integer> mll = new MyLinkedList<>();

        mll.print() // []
           .add(1)
           .print() // [1, ]
           .remove(0)
           .print() // []
           .add(1)
           .add(2)
           .print() // [1, 2, ]
           .remove(0)
           .add(3)
           .print(); // [2, 3, ]

        System.out.println(mll.get(0));
        System.out.println(mll.get(1));
    }

    private long    size = 0;
    private Node<T> head;

    @Override
    public long size() {
        return size;
    }

    @Override
    public MyLinkedList<T> add(T element) {
        if (head == null) {
            head = new Node<>(element);
        }
        else {
            Node<T> next = head;
            while (next.getNext() != null) {
                next = next.getNext();
            }
            next.setNext(new Node<>(element));
        }
        size++;
        return this;
    }

    @Override
    public T get(long index) {
        checkIndex(index);

        if (index == 0) {
            return head.getData();
        }

        Node<T> next = head;
        for (int i = 0; i <= index - 1; i++) {
            next = next.getNext();
            if (next == null) {
                throw new RuntimeException("Index is less than size, but found null node.");
            }
        }

        return next.getData();
    }

    @Override
    public MyLinkedList<T> remove(final long index) {
        checkIndex(index);

        if (size == 1) {
            head = null;
            size = 0;
            return this;
        }

        if (index == 0) {
            head = head.getNext();
            size--;
            return this;
        }

        Node<T> next = head;
        for (int i = 0; i <= index - 1; i++) {
            next = next.getNext();
            if (next == null) {
                throw new RuntimeException("Index is less than size, but found null node.");
            }
        }

        next.setNext(next.getNext() == null
                     ? null
                     : next.getNext()
                           .getNext());
        size--;
        return this;
    }

    @Override
    public MyList<T> print() {
        System.out.print("[");
        Node<T> next = head;
        while (next != null) {
            System.out.print(next.getData() + ", ");
            next = next.getNext();
        }
        System.out.println("]");
        return this;
    }

    private void checkIndex(final long index) {
        if (index > size - 1) {
            throw new RuntimeException("Index " + index + " out of range (" + size + ").");
        }

        if (size == 0) {
            throw new RuntimeException("List is empty.");
        }

        if (head == null) {
            throw new RuntimeException("Size is non-zero, but head is null.");
        }
    }
}
