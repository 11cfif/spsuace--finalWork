package ru.spsuace.projects.pass_fail.map;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


class ContainerMapTest {
    public static final int threadsAmount = 100;
    ContainerMap containerMap = new ContainerMap();
    Long aLong = Long.MAX_VALUE;
    @Test
    public void test(){

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
                containerMap.put(aLong, aLong);
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