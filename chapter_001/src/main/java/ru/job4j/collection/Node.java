package ru.job4j.collection;

public class Node<E> {
    final E value;
    Node<E> next;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }
}