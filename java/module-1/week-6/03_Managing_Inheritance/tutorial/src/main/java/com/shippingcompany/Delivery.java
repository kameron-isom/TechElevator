package com.shippingcompany;

import com.shippingcompany.Shipment;

import java.time.LocalDateTime;

public abstract class Delivery {

    String origin;
    String destination;
    int distance;
    Shipment shipment;

    public abstract int getDuration();

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrgin() {
        return origin;
    }

    public void setOrgin(String orgin) {
        this.origin = orgin;
    }
    public Shipment getShipment(){
        return  shipment;
    }

    public void setShipment(Shipment shipment){
        this.shipment = shipment;
    }

 protected int convertHoursToMinutes(double decimalHours) {
        int hours = (int) decimalHours;
        int minutes = (int) Math.round((decimalHours - hours) * 60);
        return hours * 60 + minutes; //duration in minutes
    }

    public final LocalDateTime getExpectedArrival(LocalDateTime departure){
        return departure.plusMinutes(getDuration());
    }


}
