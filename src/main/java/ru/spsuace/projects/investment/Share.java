package ru.spsuace.projects.investment;

import java.util.Date;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

public class Share extends Observable {
    public int price;
    public int minPrice;

    public void set(int price) {
        this.price = price;
    }

    public int get(int price) {
        return price;
    }

    public double dividends(Date data, double percent) {

        double result = 0;
        Date today = new Date();
        TimeUnit timeUnit = TimeUnit.DAYS;

        long difference = today.getTime() - data.getTime();
        timeUnit.convert(difference, TimeUnit.DAYS);

        if (difference > 30) {
            result = result + percent * (difference % 30);
        }
        return result;
    }

    public void priceDecrease(int money) {
        price = -money;
        if (price <= minPrice) {
            notifyObservers(this);
        }
    }
}
