package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {
    @Test


    public void isOneOrTwoLessThanMultipleOfTwenty(){
        Less20 less = new Less20();
        Assert.assertEquals(true, less.isLessThanMultipleOf20(18));
        Assert.assertEquals(true, less.isLessThanMultipleOf20(19));

    }
}
