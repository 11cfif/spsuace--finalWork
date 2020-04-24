package ru.spsuace.projects.pass_fail;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Надо реализовать ленивый синглтон. Важно, что бы объект можно было получить только через метод getInstance()
 * Так же важно, чтобы объект был создан только один раз и метод getInstance() всегда возвращал один и тот же объект.
 *
 * getInstance может вызываться из многих потоков одновременно.
 */
public class Singleton {

    private static volatile Singleton INSTANCE;
    private final int id;
    private  static final AtomicInteger counter = new AtomicInteger(0);

    public Singleton(int id) {
       this.id = id;
    }

    public int getId() {
        return id;
    }
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton(0);
                }
            }
        }
        counter.getAndIncrement();
        return INSTANCE;
    }
}
