package com.bridgelab.cabinvoicegenerator;

public class RideRepository {

    int userID;
    Ride[] rides;

    public RideRepository(int userID, Ride[] rides) {
        this.userID = userID;
        this.rides = rides;
    }

}
