package ru.spsuace.projects.car;

import java.util.ArrayList;
import java.util.List;

/**
 * Георгиев Николай
 *
 * Создать систему, имитирующую завод по изготвлению автомобилей
 * 1) Завод производит разные типы автомобилей (грузовики, микроавтобусы и тд)
 * 2) Завод может производить авто полностью сам, а может собирать из комплектующих
 * 3) Машина состоит из нескольких основных комплектующих (выберите штук 5 на свое усмотрение)
 * 4) Завод получает материалы с других заводов
 * 5) На каждую машину нужны определенное количество различных материалов
 * 6) Клиенты могут заказывать машины пачками (не более 10 за раз) или по одной штуке
 * (этот функционал можно сделать миллионом способов, самый сложный - использовать блокирующие очереди,
 * вы можете использовать любой)
 * 7) Машины делаются по мере поступления заказов
 */
public class CarFactory {
    private Car car;
    private float money;//денежный ресурс завода
    private List<Car> cars = new ArrayList<Car>();
    private List<FactoryDoor> doors = new ArrayList<FactoryDoor>();
    private List<FactoryWheel> wheels = new ArrayList<FactoryWheel>();
    private List<FactoryWind> winds = new ArrayList<FactoryWind>();
    private String typeCar;

    private void pay_door(FactoryDoor door) {
        money -= door.getPrice();
        doors.add(door);
    }

    private void pay_wheel(FactoryWheel wheel) {
        money -= wheel.getPrice();
        wheels.add(wheel);
    }

    private void pay_wind(FactoryWind wind) {
        money -= wind.getPrice();
        winds.add(wind);
    }

    public void buildCar(String typeCar, List<FactoryDoor> doors, List<FactoryWheel> wheels, List<FactoryWind> winds, float price) {

        if (doors.isEmpty()) {
            pay_door(doors);
        } else if (wheels.isEmpty()) {
            pay_wheel(wheels);
        } else if (winds.isEmpty()) {
            pay_wind(winds);
        }

        car.setType(typeCar);
        car.setPrice(price);
        car.setDoor(doors);
        car.setWindscreen(winds);
        car.setWheel(wheels);

        cars.add(car);
    }

    public void sellCar(Car car) {
        money += car.getPrice();
        cars.remove(car);
    }
}
