package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private int size = 0;
    private int modCount = 0;
    public void add(E value) {
        modCount++;
        size++;
        if (head == null) {
            head = new Node<>(value, null);
        } else {
            Node<E> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node<>(value, null);
        }
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> resultNode = head;
        for (int i = 0; i < index; i++) {
            resultNode = resultNode.next;
        }
        return resultNode.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> node = head;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E elem = node.value;
                node = node.next;
                return elem;
            }
        };
    }
}