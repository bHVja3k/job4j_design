package ru.job4j.collection;

import java.util.*;

public class SimpleSet<E> implements Iterable<E> {
    private Object[] objects;
    private int position = 0;
    private int modCount = 0;

    public SimpleSet() {
        this.objects = new Object[10];
    }

    public E get(int index) {
        Objects.checkIndex(index, position);
        return (E) this.objects[index];
    }

    public void add(E e) {
        boolean check = true;
        if (position == objects.length) {
            objects = Arrays.copyOf(objects, objects.length + 10);
        }
        for (Object el : objects) {
            if (el.equals(e)) {
                check = false;
                break;
            }
        }
        if (check) {
            this.objects[position++] = e;
            this.modCount++;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final Object[] array = objects;
            private int index = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < position;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) array[index++];
            }
        };
    }
}