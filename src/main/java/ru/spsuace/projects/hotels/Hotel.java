package ru.spsuace.projects.hotels;

/**
 * Рыжук Елизавета
 *
 * Создать систему, имитирующую отель.
 * 1) Отель имеет размер, текущую сумму на счету и бронирования на год
 * 2) Номера бывают на одного, двух, трех человек. Номера на одного и двух человек общие, но разная цена.
 * 3) Так же есть номера блочного типа (три номера по 2 человка с одним туалетом и ванной на блок)
 * 4) Клиенты пытаются забронировать номера на заданные даты и нужное количество-человек.
 * Отель предоставляет несолько вариантов, клиент выбирает только один
 * 5) Завтрак в бронь может быть включен или нет.
 * 6) Каждый номер имеет свою себестоимость (зависит от размера, типа и завтрака)
 * 7) Отель должен уметь считать потенциальную выручку на конец года
 */
public class Hotel {
    private int size;
    private double money;
    private List<HotelNumber> list;
    private List<HotelNumber> bookedNumbers = new ArrayList<>();
    private int revenue;

    public Hotel(int size, double money, List<HotelNumber> list) {
        this.size = size;
        this.money = money;
        this.list = list;
    }

    public List<HotelNumber> showFreeNumbers(int places, Date date, boolean breakfast) {
        List<HotelNumber> temp = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getPlaces() >= places
                    && list.get(i).getOrderTill().before(date)
                    && list.get(i).getBreakfast() == breakfast) {

                temp.add(list.get(i));
            }
        }
        return temp;
    }

    public void orderNumber(int places, Date date, boolean breafast) {
        List<HotelNumber> freeNumber = showFreeNumbers(places, date, breafast);

        int choosenNumber = 2; // может быть другое, в зависимости от выбора пользователя

        freeNumber.get(choosenNumber).booking(places, date);
        this.bookedNumbers.add(freeNumber.get(choosenNumber));
    }

    public int getRevenue() {
        return revenue;
    }

    public void countMoney() {
        for (int i = 0; i < this.bookedNumbers.size(); i++) {
            this.revenue += this.bookedNumbers.get(i).getPrice();
        }
    }
}