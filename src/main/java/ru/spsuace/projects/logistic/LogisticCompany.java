package ru.spsuace.projects.logistic;


import java.util.ArrayList;
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
            money -= machine.getPrice(); //вычитание
            machineList.add(machine); //добавление машины
        }

        public void sell(Machine machine) { //продать
            money += machine.priceMachine();
            machineList.remove(machine); //удаление из списка
        }

        //Сделайте методы добавления рейса
        public void addFlight(Flight flight) {
            flightList.add(flight);
            this.money -= flight.getSalary();
        }

        //Добавления дня
        public void addFlightDuration() {
            for (int i = 0; i < flightList.size(); i++) {
                Flight flight = flightList.get(i);
                flight.getMachine().setResource(flight.getMachine().getResource() - flight.getExpenses());
                this.money += flight.getPayment();
            }
        }
    }
}

