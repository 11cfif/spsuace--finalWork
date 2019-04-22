package ru.spsuace.projects.airline;

public abstract class BaseTicket {

    String name = "base ticket";

    public String getInfo() {
        return name;
    }

    public abstract int getPrice();
}
