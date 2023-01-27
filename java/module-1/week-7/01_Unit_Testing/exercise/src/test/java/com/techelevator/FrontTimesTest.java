package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    @Test

    public void getFrontLettersAndDisplayNTimes(){
       FrontTimes front = new FrontTimes();
        Assert.assertEquals("ChoChoCho", front.generateString("Chocolate",3));
        Assert.assertEquals("nono", front.generateString("no",2));
        Assert.assertEquals("a", front.generateString("a",1));



    }
}
