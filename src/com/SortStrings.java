package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class SortStrings {

    public static void main(String[] args) {

        List<String> words = new ArrayList<String>();

        words.add("Luke, you are my soon!");
        words.add("R2D2");
        words.add("Death Star");

        //Comparator<String> comparator = new ComparatorForSize();
        //Collections.sort(words, comparator);

        //Enhanced lambda
        words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println(words);

        //Implementation of an anonymous class
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        //Better approach of implementation
        words.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //Implements consumer natively with lambda
        words.forEach(word -> {
            System.out.println(word);
        });

        //Both works in the very same way using method reference in the last version
        words.sort(Comparator.comparing(s -> s.length()));
        words.sort(Comparator.comparing(String::length));


        Function<String, Integer> function = s -> s.length();
        Comparator<String> comparator = Comparator.comparing(function);
        words.sort(comparator);

        //Another Method Reference
        words.forEach(System.out::println);
    }
}
