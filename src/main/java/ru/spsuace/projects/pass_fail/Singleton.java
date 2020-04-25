package ru.spsuace.projects.pass_fail;


/**
 * Надо реализовать ленивый синглтон. Важно, что бы объект можно было получить только через метод getInstance()
 * Так же важно, чтобы объект был создан только один раз и метод getInstance() всегда возвращал один и тот же объект.
 *
 * getInstance может вызываться из многих потоков одновременно.
 *
 * НЕЛЬЗЯ ИСПОЛЬЗОВАТЬ AtomicReference
 */
public class Singleton {
    private static volatile Singleton instance;
    public static Singleton getInstance() {

       if(instance==null){
           synchronized (Singleton.class){
               if(instance == null){
                   instance = new Singleton();
               }
           }
       }
       return instance;
    }
}
