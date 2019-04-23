package ru.spsuace.projects.restaurant;

public class Sklad {
    private int number;//Его количество на складе
    private int kol;//Количество ингредиентов в заказе
    private int time;//Время доставки заказа

    public Sklad(int number, int kol, int time) {
        this.number = number;
        this.kol = kol;
        this.time = time;
    }

    public void useIngredient() {
        if (this.number == 0) {
            this.zakaz();
        } else {
            this.number--;
        }
    }

    public void zakaz() {
        try {
            Thread.sleep(this.time);
        } catch (InterruptedException ex) {
        }
        this.number = this.number + kol;
    }
}
