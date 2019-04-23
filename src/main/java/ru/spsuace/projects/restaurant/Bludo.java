package ru.spsuace.projects.restaurant;


public class Bludo {

    private Sklad ingredient1;
    private Sklad ingredient2;
    private float price;
    private int timeCook;

    public Bludo(Sklad ingredient1, Sklad ingredient2, float price, int timeCook) {
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.price = price;
        this.timeCook = timeCook;
    }

    public void zakazBludo() {

        this.ingredient1.useIngredient();
        this.ingredient2.useIngredient();
        try {
            Thread.sleep(this.timeCook);
        } catch (InterruptedException ex) {
        }

    }

}
