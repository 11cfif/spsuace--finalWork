package ru.spsuace.projects.airline;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Баланков Никита
 *
 * Создать систему, имитирующую авикомпанию.
 * 1) Авиакомпания имеет заданное количество направлений, и заданное количество самолетов
 * 2) Направление в себя включает город отлета и город прилета (считаем что один рейс происходи раз в день,
 * по четным датам - из первого города во второй, по нечетным обратно)
 * 2) Самолеты бывают нескольких типов (с разным количеством мест в бизнесс и эконом классе)
 * 3) Клиенты пытаются забронировать рейсы на заданные даты и нужное количество-человек.
 * Авиакомпания предоставляет несолько вариантов (+- 1 день, если в заданный день нет рейсов из города),
 * клиент выбирает только один вариант
 * 4) Багаж в билет может быть включен или нет.
 * 5) Каждый полет сколько-то стоит - плата за аэропорты и топливо и эксплуатацию + еда
 * 6) Авиакомпания должна уметь считать потенциальную выручку по каждому рейсу на конец года
 */
public class Airline {


    public List getFlightByDate(int day, int month, int year) {
        Calendar calendar = createCalendar(day, month, year);

        return new ArrayList();//test
    }

    public Calendar createCalendar(int day, int month, int year) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar;
    }

}
