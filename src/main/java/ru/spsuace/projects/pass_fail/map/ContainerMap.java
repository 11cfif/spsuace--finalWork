package ru.spsuace.projects.pass_fail.map;


import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Реализовать контейнер для мапы. Сам класс ClosableMap считается потокобезопасным и с ним проблем нет. Его НЕ трогать.
 * Суть в том, что после вызова метода map.close() любой другой метод map будет кидать ошибкуи крашить данные.
 * Надо избежать этого.
 * <p>
 * Можно создавать любые дополнительные методы и поля.
 * Так же можно использовать любые механизмы и объекты синхранизации в java.
 * <p>
 * Считаем, что метод close вызывается только один раз.
 * Все методы могут вызываться из разных потоков
 */
public class ContainerMap {
    private volatile Boolean closeCheck = false;
    private ClosableMap map = new ClosableMap();

    /**
     * Нельзя, чтобы вызывались методы map после вызова map.close(). В этом случае можно вернуть null
     */
    public Long put(Long key, Long value) {
        if (!closeCheck) {
            synchronized (closeCheck) {
                if (!closeCheck) {
                    return map.put(key, value);
                }
            }
        }
        return null;
    }


    /**
     * Нельзя, чтобы вызывались методы map после вызова map.close(). В этом случае можно вернуть null
     */
    public Long get(Long key) {
        if (!this.closeCheck) {
            synchronized (closeCheck) {
                if (!closeCheck) {
                    return map.get(key);
                }
            }
        }
        return null;
    }

    /**
     * Считаем, что метод вызывается только один раз
     */
    public void close() {
        if (!this.closeCheck) {
            synchronized (closeCheck) {
                if (!this.closeCheck) {
                    closeCheck = true;
                    map.close();
                }
            }
        }
    }
}
