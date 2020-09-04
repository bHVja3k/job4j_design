package ru.job4j.collection;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private final String name;
    private final int children;
    private final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public static void main(String[] args) {
        User ivan = new User("Ivan", 4, Calendar.getInstance());
        User petr = new User("Petr", 2, Calendar.getInstance());
        Map<User, Object> users = new HashMap<>();
        users.put(ivan, 1);
        users.put(petr, 2);
        for (Map.Entry<User, Object> pair : users.entrySet()) {
            User key = pair.getKey();
            Object value = pair.getValue();
            System.out.println(value + ":name-" + key.name + " children-" + key.children);
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getChildren(), getBirthday());
    }
}