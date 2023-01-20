package com.techelevator;

public class TriangleWall extends Wall {
    private int base;
    private int height;

    public TriangleWall(String name, String color, int base, int height){
        super(name, color);
        this.base= base;
        this.height= height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public String toString(){
        return getName()+ " " + "("+ base +"x" + height+ ")" + " " + "triangle" ;
    }

    @Override

    public int getArea(){
       return base*height/2;

    }

}
