package ru.spsuace.projects.logistic;

/**
 * Титов Роман
 *
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


        public List<Machine> machineList;
        public List<Flight> flightList;
        public List<Direction> directionList;

        float money; //деньги компании

        public pay(Machine machine){ //купить
            money -=machine.price; //вычитание
            this.machineList.add(machine); //добавление машины
        }
        

        public sell(Machine machine) {

            if (machine.resource < 0) {
                money += machine.price * 0.3;
            } else
                money += machine.price;
            }

        }



    }

    public class Machine { //машина
        int resource; // ресурс машины в км
        float price; //цена машины

        public Machine(int resource, float price){
            this.resource = resource;
            this.price = price;
        }
    }



    public class Flight { //рейса

        private float salary; //стоимость рейса
        private Direction direction; //путь


        public Flight(float salary, Direction direction) {
            this.salary = salary;
            this.direction = direction;
        }
    }


    public class Direction { //путь
        private String goFrom;
        private String goTo;

        public Direction(String goFrom, String goTo) {
            this.goFrom = goFrom;
            this.goTo = goTo;
        }
    }

}

