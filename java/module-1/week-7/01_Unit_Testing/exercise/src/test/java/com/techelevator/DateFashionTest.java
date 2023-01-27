package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {

    @Test

    public void getFashionTest() {
        DateFashion date = new DateFashion();
        Assert.assertEquals(2, date.getATable(8, 3));
        Assert.assertEquals(2, date.getATable(9, 3));
        Assert.assertEquals(2, date.getATable(10, 3));
        Assert.assertEquals(2, date.getATable(3, 8));
        Assert.assertEquals(1, date.getATable(4, 4));
        Assert.assertEquals(0, date.getATable(0, 1));
        Assert.assertEquals(0, date.getATable(0, 1));
        Assert.assertEquals(0, date.getATable(0, 2));
        Assert.assertEquals(0, date.getATable(1, 0));
        Assert.assertEquals(0, date.getATable(2, 0));

    }
}
