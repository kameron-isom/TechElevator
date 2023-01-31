package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {
    @Test

    public void loseTheFirstLetterOfEachString(){
        // Tech Elevator
        NonStart start = new NonStart();
        Assert.assertEquals("echlevator",start.getPartialString("Tech", "Elevator"));

    }
}
