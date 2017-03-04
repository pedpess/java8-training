package com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SortStrings {

    public static void main(String[] args) {

        List<String> words = new ArrayList<String>();

        words.add("Luke, you are my soon!");
        words.add("R2D2");
        words.add("Death Star");

        //Comparator<String> comparator = new ComparatorForSize();
        //Collections.sort(words, comparator);

        //Default method sort, concrete method into an interface (List) now using lambda
        words.sort((s1, s2) -> {
            if (s1.length() < s2.length())
                return -1;
            if (s1.length() > s2.length())
                return 1;
            return 0;
        });

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
    }
}
