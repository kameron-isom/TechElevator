package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {
@Test
    public void createAnimalGroup(){
        AnimalGroupName animal= new AnimalGroupName();
        Assert.assertEquals("Crash",animal.getHerd("rhino"));
    }
}
