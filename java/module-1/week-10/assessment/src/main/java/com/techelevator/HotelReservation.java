package com.techelevator;

public class HotelReservation {
    /*
    Fill in the class details here...
     */
    private String name;
    private int numberOfNights;
    private int nightlyRate;
    private int estimatedTotal;

    public HotelReservation(String name, int numberOfNights, int nightlyRate){
        this.name=name;
        this.numberOfNights= numberOfNights;
        this.nightlyRate=nightlyRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name= name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public int getEstimatedTotal() {
        return numberOfNights * nightlyRate;
    }


    public int getActualTotal (boolean requiresCleaning, boolean usedMinibar){
        int miniBarFee= 15;
        int cleaningFee= 25;
        if (requiresCleaning &&!usedMinibar){
           return estimatedTotal= getEstimatedTotal()+cleaningFee;
        }
        if(!requiresCleaning&& usedMinibar){
            return estimatedTotal= getEstimatedTotal()+miniBarFee;
        }
        if(usedMinibar) {
            return estimatedTotal = getEstimatedTotal() + cleaningFee + cleaningFee + miniBarFee;
        }

          return   getEstimatedTotal();
        }

    @Override
    public String toString() {
        return  name + ":" + getEstimatedTotal();
    }
}
