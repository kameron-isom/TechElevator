package com.techelevator;

public class FruitTree {
    //add instance variables
    private String typeOfFruit;
    private int piecesOfFruitLeft;


    // add getters and setters

    public String getTypeOfFruit() {
        return typeOfFruit;
    }


    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }




    // add constructors

    public FruitTree ( String typeOfFruit, int startingPiecesOfFruit){
      this.typeOfFruit =typeOfFruit;
      this.piecesOfFruitLeft = startingPiecesOfFruit ;

    }
    // adding pickFruit method
    public  boolean pickFruit ( int numberOfPiecesToRemove){
        final int MORETHANONEFRUIT = 0;
        if(piecesOfFruitLeft > MORETHANONEFRUIT) {
            piecesOfFruitLeft =piecesOfFruitLeft - numberOfPiecesToRemove;
            return true;
        }
         return false;
    }

}

