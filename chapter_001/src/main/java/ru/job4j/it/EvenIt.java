package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] data;
    int value = 0;


    public EvenIt(int[] data) {
        int[] buffer = new int[data.length];
        int count = 0;
        for (int datum : data) {
            if (datum % 2 == 0) {
                buffer[count] = datum;
                count++;
            }
        }
        this.data = Arrays.copyOf(buffer, count);
    }

    @Override
    public boolean hasNext() {
        return data.length > value;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[value++];
    }
}
