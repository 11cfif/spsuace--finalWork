package ru.spsuace.projects.travel_agency;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Создать систему, имулирующую работу туристического агенства.
 * 1) Есть клиенты, которые имеют заданный бюджет, максимальное количество дней отпуска и список желаемых городов
 * 2) Есть клиенты, которые имеют заданное количество человек и заданное направление с плавающими датами
 * 3) Есть турбазы, которые находятся в каком-то городе
 * 4) турбазы обращается в агенство и передает ему список путевок с заданными датами и ценами и количеством мест
 * 5) Клиент обращается в агенство и оставляет заявки на различные города, максимальный бюджет
 * и максимально возможные даты. Если доступные путевки есть, то клиент их сразу покупает
 * 6) Агентство накидывает на цены путевок заданный процент + уведомляет клиентов о появлении необходимых путевок
 * Процент меняется при покупек путевок оптом (от заданного количества человек)
 * 7) После покупки путевки, клиент отменяет заявки, которые уже не вписываются в бюджет, время отпуска или в его даты
 * <p>
 * Вам нужен метод где клиент хочет купить путевку, в него передается клиент
 * и по его данным подбирается путевка, если ее нет, то возращается null.
 */
public class TravelAgency {
    Map<Integer, IndClients> allIndClients = new HashMap<Integer, IndClients>();
    Map<Integer, CorpClients> allCorpClients = new HashMap<Integer, CorpClients>();
    Map<Integer, ArrayList<Camping>> Campings = new HashMap<Integer, ArrayList<Camping>>();
    int indClientsCounter;
    int corpClientsCounter;
    int CampCounter;

    public String Camp(Camping camp) {
        Campings.add(CampCounter++, camp);
    }

    double Procent;

    public TravelAgency(double procent) {
        this.Procent = procent;
    }

    public String buySingleTravel(IndClients client) {
        Camping camp = new Camping();
        int townCheck = 0;
        for (String town : client.Towns) {
            if (town == camp.City) {
                townCheck = 1;
            }
        }
        if (client.Budget >= (camp.Price + this.Procent) && (camp.DateOut - camp.DateIn) == client.Days && townCheck == 1) {
            allIndClients.put(indClientsCounter++, client);
        } else {
            return null;
        }
        return "ok";
    }


    public String buyGroupTravel(CorpClients client) {
        Camping camp = new Camping();
        if (client.Town == camp.City) {
            allCorpClients.put(corpClientsCounter++, client);
        } else {
            return null;
        }
        return "ok";
    }
}