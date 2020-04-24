package ru.spsuace.projects.pass_fail;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class SingletonTest {
    public static final int threadsAmount = 10;

    @Test
    public void singletonTest(){
        ConcurrentSkipListSet<Integer> listSet = new ConcurrentSkipListSet<>();
        CountDownLatch start = new CountDownLatch(threadsAmount);
        CountDownLatch finish = new CountDownLatch(threadsAmount);
        Executor executor = Executors.newFixedThreadPool(threadsAmount);
        for (int i = 0; i < threadsAmount; i++){
            executor.execute(()->{
                start.countDown();
                try {
                    start.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Singleton singleton = Singleton.getInstance();
                listSet.add(singleton.getId());
                finish.countDown();
            });
        }
        try {
            finish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}