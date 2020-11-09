package com.bridgelab.cabinvoicegenerator;

public class InvoiceSummary {

    private int numberOfRides;
    private double totalFare;
    private double averageFare;

    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.numberOfRides;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        InvoiceSummary invoiceSummary = (InvoiceSummary) object;
        if(invoiceSummary.numberOfRides == this.numberOfRides && this.totalFare == invoiceSummary.totalFare && this.averageFare == invoiceSummary.averageFare) return true;
        else return false;
    }

}
