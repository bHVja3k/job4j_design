package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogFilter {

    public static List<String> filter(String file) {
        List<String> found = Collections.EMPTY_LIST;
        Pattern pattern = Pattern.compile("\\s404\\s\\d");
        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
            found = inputStream.lines()
                    .filter(line -> pattern.matcher(line).find())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return found;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}