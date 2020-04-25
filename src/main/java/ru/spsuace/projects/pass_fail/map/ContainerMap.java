package ru.spsuace.projects.pass_fail.map;


/**
 * Реализовать контейнер для мапы. Сам класс ClosableMap считается потокобезопасным и с ним проблем нет. Его НЕ трогать.
 * Суть в том, что после вызова метода map.close() любой другой метод map будет кидать ошибку крашить данные.
 * Надо избежать этого.
 * <p>
 * Можно создавать любые дополнительные методы и поля.
 * Так же можно использовать любые механизмы и объекты синхранизации в java.
 * <p>
 * Считаем, что метод close вызывается только один раз.
 * Все методы могут вызываться из разных потоков
 */
public class ContainerMap {

    private ClosableMap map = new ClosableMap();
    private boolean switchClose = false;

    /**
     * Нельзя, чтобы вызывались методы map после вызова map.close(). В этом случае можно вернуть null
     */
    public Long put(Long key, Long value) {
        synchronized (this) {
            if (!switchClose) {
                return map.put(key, value);
            } else {
                return null;
            }
        }
    }

    /**
     * Нельзя, чтобы вызывались методы map после вызова map.close(). В этом случае можно вернуть null
     */
    public Long get(Long key) {
        synchronized (this) {
            if (!switchClose) {
                return map.get(key);
            } else {
                return null;
            }
        }
    }

    /**
     * Считаем, что метод вызывается только один раз
     */
    public void close() {
        synchronized (this) {
            switchClose = true;
            map.close();
        }
    }
}
