package com.bridgelab.cabinvoicegenerator;

import java.util.List;

public class CabInvoiceGenerator {

    public double calculateNormalFare(double distance, int time) {
        return CabRide.NORMAL.calculateFarePerRide(distance, time);
    }

    public double calculatePremiumRideFare(double distance, int time) {
        return CabRide.PREMIUM.calculateFarePerRide(distance, time);
    }

    public double calculateTotalAggregateFare(List<Ride> rides) {
        double totalFareForAllRides = 0;
        for (Ride ride : rides) {
            if(ride.cabRideType != null)
                totalFareForAllRides += ride.cabRideType.calculateFarePerRide(ride);
        }
        return totalFareForAllRides;
    }

}
