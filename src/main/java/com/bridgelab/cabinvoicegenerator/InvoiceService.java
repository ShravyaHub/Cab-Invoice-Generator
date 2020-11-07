package com.bridgelab.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    private List<RideRepository> rideRepository;

    public InvoiceService(List<RideRepository> rideRepository) {
        this.rideRepository = rideRepository;
    }

    public InvoiceSummary getInvoice(int userID) {
        InvoiceSummary invoiceSummary = null;
        for (RideRepository userRides : rideRepository) {
            if (userRides.userID == userID) {
                invoiceSummary = new CabInvoiceGenerator().getInvoiceSummary(userRides.rides);
            }
        }
        return invoiceSummary;
    }

}