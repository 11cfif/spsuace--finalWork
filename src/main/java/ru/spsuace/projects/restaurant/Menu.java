package ru.spsuace.projects.restaurant;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Menu {
    private List<Bludo> Bluda;
    private int choseTime;

    public Menu(List<Bludo> Bluda, int choseTime) {
        this.Bluda = Bluda;
        this.choseTime = choseTime;
    }

    public void chose() {
        try {
            Thread.sleep(this.choseTime);
        } catch (InterruptedException ex) {
        }
        Bluda.get(ThreadLocalRandom.current().nextInt(1, Bluda.size()));
    }

}
