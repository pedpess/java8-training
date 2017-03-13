package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Pedro Pessoa on 07/03/2017.
 */

class Course {
    private String name;
    private int student;

    public Course(String name, int student) {
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public int getStudent() {
        return student;
    }
}
public class ExampleCourses {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Python", 45));
        courses.add(new Course("JavaScript", 150));
        courses.add(new Course("Java 8", 113));
        courses.add(new Course("C", 55));

        courses.sort(Comparator.comparing(Course::getName));
        //courses.forEach(course -> System.out.println(course.getName()));

        courses.stream()
                .filter(course -> course.getStudent() >= 100)
                .forEach(course -> System.out.println(course.getName()));

        courses.stream()
                .filter(course -> course.getStudent() >= 100)
//                .map(course -> course.getStudent())
//                .forEach(total -> System.out.println(total));

        //Or Method Reference

                .map(Course::getStudent)
                .forEach(System.out::println);

        //Mapping for a different primal variable
        IntStream sumStream = courses.stream()
                .filter(course -> course.getStudent() >= 100)
                .mapToInt(Course::getStudent);

        int sum = sumStream.sum();

        System.out.println(sum);

    }
}
