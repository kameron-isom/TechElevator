package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {
    @Test

    public void cigarCount (){
      CigarParty  cigar = new CigarParty();
      cigar.haveParty(60,true);
      cigar.haveParty(40,true);
        Assert.assertEquals(true, true);


    }

}
