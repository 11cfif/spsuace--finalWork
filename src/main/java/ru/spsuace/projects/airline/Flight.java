package ru.spsuace.projects.airline;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Flight {

    private Aircraft aircraft;
    private Direction direction;
    private BaseTicket ticket;

    public Flight (Aircraft aircraft, Direction direction, BaseTicket ticket) {
        this.aircraft = aircraft;
        this.direction = direction;
        this.ticket = ticket;
    }

    public void chooseDirection(Calendar calendar) {
        direction.change(calendar);
    }

}
