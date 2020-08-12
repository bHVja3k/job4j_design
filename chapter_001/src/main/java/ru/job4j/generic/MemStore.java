package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        mem.set(mem.indexOf(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        mem.remove(mem.indexOf(id));
        return true;
    }

    @Override
    public T findById(String id) {
        return (T) mem.stream()
                .filter(m -> m.getId().equals(id));
    }
}