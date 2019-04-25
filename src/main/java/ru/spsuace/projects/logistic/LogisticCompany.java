package ru.spsuace.projects.logistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Титов Роман
 * <p>
 * Создать систему, имитирующую логистическую компанию
 * 1) Компания имеет некоторое количество разных машин
 * 2) Каждая машина имеет свой ресурс (в киломметрах), по истечению ресурсов машина продается за 30% своей стоимости
 * 3) Машины покупаются на заводе
 * 4) Компания отправляет машины в рейс в различные города (у рейса фиксированная стоимость,
 * которая снимается в начале поездки и фиксированная оплата, которая поступает в конце поездки. Так же у рейса задано
 * количество и тип машин,а так  же задана продолжительность рейса)
 * 5) Можно изменять время специальным методом (в котором прибаялется некоторое количество дней)
 * 6) Если существует рейс на 5 дней, который отправился сегодня, затем мы прибавили 8 дней, считаем что рейс повторился
 * 7) Если в предыдущем пункте мы прибавили 5 дней, но ни одногорейса не создали заново, и прибавили еще 5 дней,
 * машины простаивает
 * 8) У компании должен быть метод, который показывает текущие рейсы, количество машин и текущую сумму на счету
 * 9) Считаем, что количество машин изначално 0, но есть большой капитал
 */
public class LogisticCompany {

    public class Company {

        //private

        private final List<Machine> machineList = new ArrayList<Machine>();
        private final List<Flight> flightList = new ArrayList<Flight>();

        float money; //деньги компании

        public void pay(Machine machine) { //купить
            money -= machine.price; //вычитание
            machineList.add(machine); //добавление машины
        }

        public void sell(Machine machine) { //продать
            money += machine.priceMachine();
            machineList.remove(machine); //удаление из списка
        }

        //Сделайте методы добавления рейса
        public void addFlight(Flight flight) {
            flightList.add(flight);
            this.money -= flight.salary;
        }

        //Добавления дня
        public void addFlightDuration() {
            for (int i = 0; i < flightList.size(); i++) {
                Flight flight = flightList.get(i);
                flight.machine.resource -= flight.expenses;
                this.money += flight.payment;
            }
        }
    }

    public class Machine { //машина
        private int resource; // ресурс машины
        private final float price; //цена машины

        public Machine(int resource, float price) {
            this.resource = resource;
            this.price = price;
        }

        public float priceMachine() { //Цена машины
            if (this.resource <= 0) {
                return (float) (this.price * 0.3);
            } else {
                return this.price;
            }
        }
    }


    public class Flight { //рейс

        private final float salary; //стоимость рейса
        private final float payment; //оплата рейса
        private final Direction direction; //путь
        private final int flightDuration = 1; // продолжительность рейса
        private final int expenses; // затраты ресурсов
        private Machine machine;

        public Flight(float salary, float payment, Direction direction, int expenses, Machine machine) {
            this.salary = salary;
            this.payment = payment;
            this.direction = direction;
            this.expenses = expenses;
            this.machine = machine;
        }
    }

    public class Direction { //путь
        private final String goFrom;
        private final String goTo;

        public Direction(String goFrom, String goTo) {
            this.goFrom = goFrom;
            this.goTo = goTo;
        }
    }

}

