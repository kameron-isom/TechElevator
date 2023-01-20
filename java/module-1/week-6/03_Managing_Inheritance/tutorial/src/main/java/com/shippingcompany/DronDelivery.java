package com.shippingcompany;

public class DronDelivery extends  Delivery{
    public static final int DRONE_TOP_SPEED = 100;

    @Override
    public int getDuration(){
        int weight= super.getShipment().getWeight();
        double topSpeedWithWeight =DRONE_TOP_SPEED/weight;
        double decimalHours = super.getDistance() / topSpeedWithWeight;
        return convertHoursToMinutes(decimalHours);

    }
}
