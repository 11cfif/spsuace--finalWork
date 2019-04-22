package ru.spsuace.projects.airline;

public class FullTicket extends TicketDecorator {

    Ticket ticket;
    private int baggagePrice = 500;

    public FullTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String getInfo() {
        return ticket.getInfo() + " with  baggage";
    }

    @Override
    public int getPrice() {
        return ticket.getPrice() + baggagePrice;
    }
}
