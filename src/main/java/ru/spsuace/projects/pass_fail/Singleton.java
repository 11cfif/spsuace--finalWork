package ru.spsuace.projects.pass_fail;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Надо реализовать ленивый синглтон. Важно, что бы объект можно было получить только через метод getInstance()
 * Так же важно, чтобы объект был создан только один раз и метод getInstance() всегда возвращал один и тот же объект.
 * <p>
 * getInstance может вызываться из многих потоков одновременно.
 * <p>
 * НЕЛЬЗЯ ИСПОЛЬЗОВАТЬ AtomicReference
 */
public class Singleton {
    private final int id;
    private static volatile Singleton instance;
    private static final AtomicInteger counter = new AtomicInteger(0);

    private Singleton(int id) {
        this.id = id;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(counter.getAndIncrement());
                }
            }
        }
        return instance;
    }
}
