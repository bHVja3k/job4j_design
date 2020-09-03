package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIter<T> implements Iterator<T> {
    private final Object[] objects;
    private int point = 0;
    private final int currentLength;

    public ArrayIter(Object[] objects, int currentLength) {
        this.objects = objects;
        this.currentLength = currentLength;
    }

    @Override
    public boolean hasNext() {
        return point < currentLength;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) objects[point++];
    }
}