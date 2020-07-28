package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private final int size;
    private int row;
    private int column;

    public MatrixIt(int[][] data) {
        this.data = data;
        this.size = getElementCount(data);
    }

    private int getElementCount(int[][] data) {
        int count = 0;
        for (int[] value : data) {
            count += value.length;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return 0 < size;
    }

    @Override
    public Integer next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        while (row < data.length && column >= data[row].length) {
            column = 0;
            row++;
        }
        return data[row][column++];
    }
}