package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIter<T> implements Iterator<T> {
    private Object[] objects;
    private int point = 0;
    private int currentLength;

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