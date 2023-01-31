package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;

public class Lucky13Test {
    @Test

    public void ifContainsOneOrThree(){
        Lucky13 lucky = new Lucky13();
        int numberArray [] = new int[]{1,2,4};

       Assert.assertEquals(false,lucky.getLucky(numberArray));

    }
}
