package ru.job4j.generic;

import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    Object[] objects;
    int index = 0;
    int size = objects.length;

    public void add(T model) {
        this.objects[index++] = model;
    }

    public void set(int index, T model) {
        this.objects[index] = model;
    }

    public void remove(int index) {
        this.objects[index] = null;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) this.objects[index];
    }

    @Override
    public java.util.Iterator iterator() {
        return new ArrayIter<T>(this.objects, index);
    }

}
