package ru.spsuace.projects.car;

import java.util.List;

public class Car {
    //у каждой машины свой тип
    //свой набор частей и своя цена
    private String type;
    private List<FactoryWheel> wheel;
    private List<FactoryWind> windscreen;
    private List<FactoryDoor> door;
    private float price;

    public Car(String type, List<FactoryDoor> doors, List<FactoryWheel> wheels, List<FactoryWind> winds, float price) {
        this.type = type;
        this.wheel = wheel;
        this.windscreen = windscreen;
        this.door = door;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDoor(List<FactoryDoor> door) {
        this.door = door;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setWheel(List<FactoryWheel> wheel) {
        this.wheel = wheel;
    }

    public void setWindscreen(List<FactoryWind> windscreen) {
        this.windscreen = windscreen;
    }
}
