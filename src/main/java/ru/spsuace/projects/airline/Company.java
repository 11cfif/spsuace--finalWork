package ru.spsuace.projects.airline;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class Company {

    public List<Aircraft> aircrafts;
    public List<Direction> directions;
    private List<Flight> flights;

    public Company(List<Aircraft> aircrafts, List<Direction> directions) {
        this.aircrafts = aircrafts;
        this.directions = directions;
        flights = createFlightList(this.aircrafts, this.directions);
    }

    private List<Flight> createFlightList(List<Aircraft> aircrafts, List<Direction> directions) {
        List<Flight> list = new ArrayList<>();
        Random random = new Random();
        int numOfFlights = random.nextInt(10);

        for (int i = 0; i < numOfFlights + 1; i++) {
            int numOfAircraft = random.nextInt(aircrafts.size());
            int numOfDirection = random.nextInt(directions.size());
            int numOfTicket = random.nextInt(2);

            if (numOfTicket == 1) {
                Ticket ticket1 = new Ticket();
                FullTicket ticket = new FullTicket(ticket1);
                list.add(new Flight(aircrafts.get(numOfAircraft),directions.get(numOfDirection), ticket));
            } else {
                Ticket ticket = new Ticket();
                list.add(new Flight(aircrafts.get(numOfAircraft),directions.get(numOfDirection), ticket));
            }

        }

        return list;
    }

    public List<Flight> getFlights(String goFrom, String goTo, Calendar calendar) {
        List<Flight> flight = this.flights;
        Calendar dates = calendar;
        for (int i = 0; i < flight.size(); i++) {
            //Change diraction and back list
        }
        return flight;
    }


}
