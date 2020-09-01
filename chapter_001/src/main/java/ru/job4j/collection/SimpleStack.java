package ru.job4j.collection;

import java.util.Iterator;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();

    // Метод pop() - должен возвращать значение и удалять его из коллекции.
    public T pop() {
        Iterator<T> it = linked.iterator();
        T rsl = it.next();
        linked.deleteFirst();
        return rsl;
    }

    //Метод push(T value) - помещает значение в коллекцию.
    public void push(T value) {
        linked.add(value);
    }
}
