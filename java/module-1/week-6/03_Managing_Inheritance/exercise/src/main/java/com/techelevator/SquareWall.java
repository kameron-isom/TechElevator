package com.techelevator;

public class SquareWall extends  RectangleWall{

    private int sideLength;

    public SquareWall(String name, String color, int sideLength){
        super(name,color,0,0 );
        this.sideLength= sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    public String toString(){
        return getName()+ " " + "("+ sideLength +"x" + sideLength+ ")" + " " + "square" ;
    }



    @Override

    public int getArea(){
        return sideLength *sideLength;
    }
}
