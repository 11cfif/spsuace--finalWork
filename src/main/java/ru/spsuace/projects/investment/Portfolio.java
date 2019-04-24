package ru.spsuace.projects.investment;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.abs;

/**
 * Широбокова Полина
 * <p>
 * Нужно имулировать работу инвестиционного портфеля
 * 1) Есть рынок акций, акции могут менять свою цену
 * 2) Есть портфель на который можно вводить и выводить средства
 * 3) Можно покупать акции в портфель по заданной цене
 * 4) Можно ставить стоп-лоссы и тэйк-профиты, которые будут автомотически покупать/продавать нужное количество акций,
 * если цена достигла некоторого значения
 * 5) По некоторым акциям иногда платятся диведенды
 * 6) За каждую сделку списывается заданная комиссия
 * 7) Портфель всегда должен отображать текущую стоимость
 * 8) Так же он должен а процентом соотношении показывать сколько мы заработали/потеряли
 */
public class Portfolio implements Observer {
        private int money;
        private int totalGet;
        private int totalLose;
         Map<Integer, Share> totalTable = new HashMap<Integer, Share>();
         private int stockCount;

        public void earn(int money){
            this.money=+money;
            this.totalGet=+money;
        }

        public void waste(int money){
            this.money=-money;
            this.totalLose=+money;
        }

        public  void addStock(Share share) {
            totalTable.put(stockCount++, share);
            money = -totalTable.get(stockCount).price;
            this.totalLose = +totalTable.get(stockCount).price;
            Iterator iterator1 = totalTable.entrySet().iterator();
            int i = 0;
            while (iterator1.hasNext()) {
                money = +totalTable.get(i).price;
                totalGet = +totalTable.get(i).price;
                i++;
            }
        }
        public int totalMoney(){
            int i=0;
            Iterator iterator = totalTable.entrySet().iterator();
            while (iterator.hasNext()){
                money=+totalTable.get(i).price;
                totalGet=+totalTable.get(i).price;
                i++;
            }
            return money;
        }
        public double diffGetLose(){
            return abs(totalGet-totalLose)/totalLose*100;
        }

    @Override
    public void update(Observable Share, Object arg) {
            Share share=Share.class.cast(arg);
        addStock(share);
    }
}





