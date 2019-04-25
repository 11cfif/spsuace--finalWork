package ru.spsuace.projects.petrol;

import java.util.List;

public class Client<T> {
    private final List<T> shoppingList;
    private final int liters;
    private int minsForBuy = 3;

    public Client(List<T> shoppingList, int liters) {
        this.shoppingList = shoppingList;
        this.liters = liters;
    }

    public int getMinsForBuy() {
        return minsForBuy;
    }

    public int getLiters() {
        return liters;
    }

    public List<T> getShoppingList() {
        return shoppingList;
    }
}
