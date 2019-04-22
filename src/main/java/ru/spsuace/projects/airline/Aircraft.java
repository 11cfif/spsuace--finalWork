package ru.spsuace.projects.airline;

public class Aircraft {
    private int businesPlaces;
    private int economyPlaces;

    public Aircraft(int businesPlaces, int economyPlaces) {
        this.businesPlaces = businesPlaces;
        this.economyPlaces = economyPlaces;
    }

    public int getBusinesPlaces() {
        return businesPlaces;
    }

    public int getEconomyPlaces() {
        return economyPlaces;
    }

}
