package ru.spsuace.projects.petrol;

/**
 * Субботина Елена
 *
 * Создать систему, имитирующую бензокологку
 * 1) Заправка умеет заправлять машины, продавать некоторые товары + кофе с выпечкой (3 направления деятельности)
 * 2) Количество колонок на заправке ограничено
 * 3) Клиенты обязательно заправляются + плюс могут что-то купить дополнительно
 * 4) Способ заправки меняется в зависимости от времени:
 * с 23.00 до 6.00 - сначала заплати (заданное время для всех клиентов), потом заправь (время зависит от объема топлива)
 * - тут общее время равно MAX(Тпокупок, Тзаправки)
 * с 6:00 до 23:00 - сначала заправь, потом заплати - здесь общее время Тпокупок + Тзаправки
 * 5) Клиент заранее имеет заданные потребности (количество литров, которое надо заправить и набор покупок)
 * 6) В очереди могут быть не более 12 машин (6 стоят у колонок, 6 ждут) При попытке добавить нового клиента - он уезжает
 * 7) В любой момент времени можно узнать количество клиентов, прошедших через заправку; количество выручки по направлениям
 */

import javax.xml.crypto.Data;
import java.util.*;

public class PetrolStation {
    final List<GasStation> gasStationsList;
    Map<GasStation, Integer> clientMap = new HashMap<>();
    Calendar calendarNow = new GregorianCalendar();

    public PetrolStation(List<GasStation> gasStationsList) {
        this.gasStationsList = gasStationsList;
    }

    public int Ticket(Client client, GasStation gasStation, Calendar date, boolean otherPurchases, boolean coffee) {
        Calendar calendarMin = new GregorianCalendar();
        calendarMin.set(Calendar.HOUR, 6);

        Calendar calendarMax = new GregorianCalendar();
        calendarMax.set(Calendar.HOUR, 23);

        int price = 0;

        if (date.after(calendarMax) && date.before(calendarMin)) {
            // купить по способу с 23 до 6 - сначала заплати (заданное время для всех клиентов), потом заправь (время зависит от объема топлива)
        } else {
            price += fillCar(client, gasStation);
            gasStation.clientTime += client.getMinsForBuy();

            if (otherPurchases) {
                price += purchases(client, gasStation);
            }

            if (coffee) {
                price += buyCoffee(client, gasStation);
            }
        }

        if (clientMap.containsKey(gasStation)) {
            Integer value = clientMap.get(gasStation);
            clientMap.put(gasStation, value + 1);
        } else {
            clientMap.put(gasStation, 1);
        }

        return price;
    }

    public int getClientsNumber(GasStation gasStation) {
        return clientMap.get(gasStation);
    }

    public int fillCar(Client client, GasStation gasStation) {
        gasStation.clientTime += client.getLiters() * 2;
        return client.getLiters() * 40;
    }

    public int purchases(Client client, GasStation gasStation) {
        List wishList = client.getShoppingList();
        int price = 0;

        for (int i = 0; i < wishList.size(); i++) {
            price += i * 200;
            gasStation.clientTime += i * 2;
        }

        return price;
    }

    public int buyCoffee(Client client, GasStation gasStation) {
        gasStation.clientTime += 2;
        int price = 300;
        return price;
    }
}
