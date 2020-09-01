package ru.job4j.collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T get(int index) {
        Node<T> resultNode = head;
        for (int i = 0; i < index; i++) {
            resultNode = resultNode.next;
        }
        return resultNode.value;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            Node<T> node = head;
            head = node.next;
        }
    }

    public void deleteLast(){
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            Node<T> node = head;
            head = node.next;
        }
    }

    public void revert() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tmp;
        Node<T> current = head.next;
        while (current != null) {
            tmp = head;
            head = current;
            current = head.next;
            head.next = tmp;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}