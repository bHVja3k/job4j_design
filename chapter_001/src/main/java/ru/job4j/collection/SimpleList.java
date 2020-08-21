package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleList<E> implements Iterable<E> {
    private Node<E> node;
    private Node<E> first;
    private Node<E> last;
    private int position = 0;
    private int modCount = 0;

    public SimpleList(Node <E> node) {
        this.node = node;
    }

    public E get(int index) {
        Objects.checkIndex(index, position);
        return (E) this.node;
    }

    public void add(E value) {
        return;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}