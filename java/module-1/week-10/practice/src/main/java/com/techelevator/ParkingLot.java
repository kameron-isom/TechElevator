package com.techelevator;

public class ParkingLot {

    // DO NOT REMOVE the DEFAULT_NUMBER_OF_... constants!!!!!
    public static final int DEFAULT_NUMBER_OF_COMPACT_SLOTS = 3;
    public static final int DEFAULT_NUMBER_OF_MIDSIZE_SLOTS = 5;
    public static final int DEFAULT_NUMBER_OF_FULLSIZE_SLOTS = 2;
    

    /*
    Fill in the class details here...
     */
    private String name;
    private boolean open=false;
    private int numberOfCompactSlots;
    private int numberOfMidsizeSlots;
    private int numberOfFullsizeSlots;


    public ParkingLot(String name){
        this(name,false);

    }


    public ParkingLot(String name, boolean open){
        this(name,open,DEFAULT_NUMBER_OF_COMPACT_SLOTS,DEFAULT_NUMBER_OF_MIDSIZE_SLOTS, DEFAULT_NUMBER_OF_FULLSIZE_SLOTS);
    }
    public ParkingLot(String name, boolean open, int numberOfCompactSlots, int numberOfFullsizeSlots, int numberOfMidsizeSlots ){
        this.name=name;
        this.open=open;
        this.numberOfCompactSlots=numberOfCompactSlots;
        this.numberOfFullsizeSlots=numberOfFullsizeSlots;
        this.numberOfMidsizeSlots=numberOfMidsizeSlots;

    }

    public String getName() {
        return this.name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open=open;
    }

    public int getNumberOfCompactSlots(){
        return numberOfCompactSlots;
    }

    public int getNumberOfMidsizeSlots() {
        return numberOfMidsizeSlots;
    }

    public int getNumberOfFullsizeSlots(){
        return numberOfFullsizeSlots;

    }


    public int getLotSize(){
        return DEFAULT_NUMBER_OF_COMPACT_SLOTS+ DEFAULT_NUMBER_OF_FULLSIZE_SLOTS+ DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
    }

    public int numberOfAvailableSlots (String carType){
        if(carType.equals(toString())){
           int avaliableMidSizedSlots= DEFAULT_NUMBER_OF_MIDSIZE_SLOTS-numberOfMidsizeSlots;
        }
        return 0;
    }

    public boolean park(Car car){
        return true;
    }

    public Car exit(String car, String license){
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
