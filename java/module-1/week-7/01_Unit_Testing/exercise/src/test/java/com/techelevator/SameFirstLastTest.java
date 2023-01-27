package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTest {

    public SameFirstLast same = new SameFirstLast();

    @Test

    public void firstAndLastElementsAreEqual (){
         SameFirstLast same = new SameFirstLast();
        int [] answer = {5,2,3,5};
        Assert.assertEquals(true, same.isItTheSame(answer));
    }

    @Test

    public void arrayIsEmpty(){
        SameFirstLast same = new SameFirstLast();
        int [] empty = {};
        Assert.assertEquals(false,same.isItTheSame(empty) );
    }
}
