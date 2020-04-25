package ru.spsuace.projects.pass_fail;

import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {
    @Test
    public void getInstanceTest() {
        Singleton singleton = Singleton.getInstance();
        Assert.assertSame(singleton, Singleton.getInstance());
    }
}
