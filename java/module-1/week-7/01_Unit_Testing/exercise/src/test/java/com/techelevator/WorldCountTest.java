package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WorldCountTest {
    @Test
    public void getTheNumberOfStringInAnArray(){
        WordCount count = new WordCount();
        String [] input ={"ba","ba","black","sheep"};
        Map<String, Integer> answer= new HashMap<>();
        answer.put("ba",2);
        answer.put("black",1);
        answer.put("sheep",1);
        Assert.assertEquals(answer, count.getCount(input) );
    }
}
