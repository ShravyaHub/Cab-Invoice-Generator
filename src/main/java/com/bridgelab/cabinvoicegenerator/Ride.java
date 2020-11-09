package com.bridgelab.cabinvoicegenerator;

public class Ride {

    public double distance;
    public int time;
    public CabRide cabRideType;

    public Ride(double distance, int time, CabRide cabRideType) {
        this.distance = distance;
        this.time = time;
        this.cabRideType = cabRideType;
    }

}
