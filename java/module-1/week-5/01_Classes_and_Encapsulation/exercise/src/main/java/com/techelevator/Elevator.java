package com.techelevator;

public class Elevator {
//  add instance variables
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;

    // constructor

    public Elevator(int numberOfLevels ){
        currentFloor =1;
        numberOfFloors = numberOfLevels;
    }

    // add getters

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public  boolean isDoorOpen(){
        return  doorOpen;
    }

    public void openDoor(){
        doorOpen= true;

    }
    public void closeDoor(){
        doorOpen = false;
    }
    public void goUp(int desiredFloor){
        if(!doorOpen && desiredFloor<= numberOfFloors && desiredFloor>currentFloor){
            currentFloor= desiredFloor;
        }

    }
    public void goDown(int desiredFloor){
        if (desiredFloor>= 1 && currentFloor> desiredFloor && !doorOpen){
            currentFloor = desiredFloor;
        }
        
    }
}
