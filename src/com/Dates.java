package com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Created by Pedro Pessoa on 15/03/2017.
 */
public class Dates {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate nextSoccerMatch = LocalDate.of(2017,03, 31);

        Period period = Period.between(today, nextSoccerMatch);

        System.out.println(period.getDays());


        //nextSoccerMatch is immutable
        nextSoccerMatch.plusWeeks(2);

        System.out.println(nextSoccerMatch);

        //Now it works
        LocalDate nextChampionship = nextSoccerMatch.plusWeeks(2);

        System.out.println(nextChampionship);

        //Formatting Dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
        String formattedValues = nextChampionship.format(formatter);
        System.out.println(formattedValues);


        //Formatting Hours
        DateTimeFormatter formatterWithHours = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(formatterWithHours));

        LocalTime interval = LocalTime.of(12, 30);
        System.out.println(interval);
    }
}
