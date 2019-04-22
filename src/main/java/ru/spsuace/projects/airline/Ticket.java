package ru.spsuace.projects.airline;

public class Ticket extends BaseTicket {

    private int airportPrice = 4000;
    private int fuelPrice = 1000;
    private int exploitationPrice = 3000;
    private int foodPrice = 1000;

    public Ticket() {
        name = "Ticket";
    }

    @Override
    public int getPrice() {
        return airportPrice + fuelPrice + foodPrice + exploitationPrice;
    }

}
