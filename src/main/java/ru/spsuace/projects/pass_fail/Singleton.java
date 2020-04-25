package ru.spsuace.projects.pass_fail;


/**
 * Надо реализовать ленивый синглтон. Важно, что бы объект можно было получить только через метод getInstance()
 * Так же важно, чтобы объект был создан только один раз и метод getInstance() всегда возвращал один и тот же объект.
 * <p>
 * getInstance может вызываться из многих потоков одновременно.
 * <p>
 * НЕЛЬЗЯ ИСПОЛЬЗОВАТЬ AtomicReference
 */
public class Singleton {
    private Singleton() {
    }

    private static class SingletonHolder {
        private final static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
