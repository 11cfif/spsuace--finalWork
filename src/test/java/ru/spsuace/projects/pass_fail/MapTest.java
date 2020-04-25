package ru.spsuace.projects.pass_fail;

import org.junit.Assert;
import org.junit.Test;
import ru.spsuace.projects.pass_fail.map.ClosableMap;
import ru.spsuace.projects.pass_fail.map.ContainerMap;

public class MapTest {
    @Test
    public void putTest() {
        ContainerMap containerMap = new ContainerMap();
        ClosableMap closableMap = new ClosableMap();
        Assert.assertEquals(containerMap.put((long) 0, (long) 1), closableMap.put((long) 0, (long) 1));
    }

    @Test
    public void getTest() {
        ContainerMap containerMap = new ContainerMap();
        containerMap.put((long) 0, (long) 1);
        ClosableMap closableMap = new ClosableMap();
        closableMap.put((long) 0, (long) 1);
        Assert.assertEquals(containerMap.get((long) 0), closableMap.get((long) 0));
    }

    @Test
    public void closeTest() {
        ContainerMap containerMap = new ContainerMap();
        containerMap.put((long) 0, (long) 1);
        containerMap.close();
        Assert.assertNull(containerMap.get((long) 0));
    }
}
