package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    @Test
    public void array_ShouldHaveThreeOfTheHighestValuesOfTheLargestNumber(){
        MaxEnd3 max= new MaxEnd3();
        int[] newArray = new int[] {11,11,11};
        int[] originalArray = new int [] {11,5,9};
        Assert.assertEquals(originalArray,max.makeArray(newArray));

    }
}
