package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTest {
    @Test
    public void stringReturnsEveryOtherWord(){
        //teeth
        StringBits bits = new StringBits();
        Assert.assertEquals("teh",bits.getBits("teeth"));

    }
}
