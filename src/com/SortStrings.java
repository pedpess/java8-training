package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class SortStrings {

    public static void main(String[] args) {

        List<String> words = new ArrayList<String>();

        words.add("Luke, you are my soon!");
        words.add("R2D2");
        words.add("Death Star");

        Comparator<String> comparator = new ComparatorForSize();
        //Collections.sort(words, comparator);

        //Default method sort, concrete method into an interface (List)
        words.sort(comparator);

        System.out.println(words);

        //Implements consumer natively
        words.forEach(word -> {
            System.out.println(word);
        });

        //Implementation of consumer
        Consumer<String> consumer = new PrintLines();
        words.forEach(consumer);
    }

    public static class ComparatorForSize implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            if (s1.length() < s2.length())
                return -1;
            if (s1.length() > s2.length())
                return 1;
            return 0;
        }
    }

    public static class PrintLines implements Consumer<String> {

        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }
}
