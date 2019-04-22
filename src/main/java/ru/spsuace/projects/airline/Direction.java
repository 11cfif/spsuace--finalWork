package ru.spsuace.projects.airline;

import java.util.Calendar;

public class Direction {
    private String goFrom;
    private String goTo;

    public Direction(String goFrom, String goTo) {
        this.goFrom = goFrom;
        this.goTo = goTo;
    }

    public void change(Calendar calendar) {
        if ((calendar.get(calendar.DAY_OF_MONTH) / 2) != 0) {
            String temp = goTo;
            goTo = goFrom;
            goFrom = temp;
        }
    }

}
