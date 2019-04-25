package ru.spsuace.projects.logistic;


public class Machine { //машина
    private int resource; // ресурс машины
    private final float price; //цена машины

    public Machine(int resource, float price) {
        this.resource = resource;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public float priceMachine() { //Цена машины
        if (this.resource <= 0) {
            return (float) (this.price * 0.3);
        } else {
            return this.price;
        }
    }
}
