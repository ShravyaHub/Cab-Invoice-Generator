package com.bridgelab.cabinvoicegenerator;

import java.util.List;

public class InvoiceService {

    public RideRepository rideRepository;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

    public InvoiceSummary getInvoice(int userID) throws InvoiceException {
        if(!rideRepository.getRideRepositoryMap().containsKey(userID))
            throw new InvoiceException("Invalid user id", InvoiceException.ExceptionType.INVALID_USER_ID);
        else {
            return getInvoiceSummary(rideRepository.getUserRideList(userID));
        }
    }

    public InvoiceSummary getInvoiceSummary(List<Ride> rides) throws InvoiceException {
        double totalFare = new CabInvoiceGenerator().calculateTotalAggregateFare(rides);
        return new InvoiceSummary(rides.size(), totalFare);
    }

    public void addRide(int userID, List<Ride> rides) {
        rideRepository.addRide(userID, rides);
    }

}
