package ru.spsuace.projects.pass_fail.map;


import java.util.concurrent.atomic.AtomicReference;

/**
 * Реализовать контейнер для мапы. Сам класс ClosableMap считается потокобезопасным и с ним проблем нет. Его НЕ трогать.
 * Суть в том, что после вызова метода map.close() любой другой метод map будет кидать ошибкуи крашить данные.
 * Надо избежать этого.
 *
 * Можно создавать любые дополнительные методы и поля.
 * Так же можно использовать любые механизмы и объекты синхранизации в java.
 *
 * Считаем, что метод close вызывается только один раз.
 * Все методы могут вызываться из разных потоков
 */
public class ContainerMap {

    public static AtomicReference<ContainerMap> instanceMap = new AtomicReference<>();

    private ClosableMap map = new ClosableMap();

    /**
     * Нельзя, чтобы вызывались методы map после вызова map.close(). В этом случае можно вернуть null
     */
    public Long put(Long key, Long value) {
        return map.put(key, value);
    }


    /**
     * Нельзя, чтобы вызывались методы map после вызова map.close(). В этом случае можно вернуть null
     */
    public Long get(Long key) {
        return map.get(key);
    }

    /**
     * Считаем, что метод вызывается только один раз
     */
    public void close() {
        map.close();
    }
}
