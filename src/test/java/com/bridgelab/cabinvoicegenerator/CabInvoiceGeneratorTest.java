package com.bridgelab.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator invoiceGenerator;
    InvoiceService invoiceService;

    @Before
    public void initialize() {
        invoiceGenerator = new CabInvoiceGenerator();
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTimeForNormalRide_IfFareGreaterThanMinimumFare_ShouldReturnTotalFare() {
        double distance = 10;
        int time = 12;
        Assert.assertEquals(112, new CabInvoiceGenerator().calculateNormalFare(distance, time), 0.0);
    }

    @Test
    public void givenDistanceAndTimeForPremiumRide_IfFareLessThanMinimumFare_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        Assert.assertEquals(20, new CabInvoiceGenerator().calculatePremiumRideFare(distance, time), 0.0);
    }

    @Test
    public void givenMultipleRidesForNormalRides_ShouldReturnTotalFare() {
        Ride[] rides = { new Ride(10, 15, CabRide.NORMAL), new Ride(3, 8, CabRide.NORMAL), new Ride(4, 10, CabRide.NORMAL) };
        Assert.assertEquals(203, new CabInvoiceGenerator().calculateTotalAggregateFare(Arrays.asList(rides)), 0.0);
    }

    @Test
    public void givenMultipleRidesForPremiumRides_ShouldReturnInvoiceSummary() throws InvoiceException {
        Ride[] rides = { new Ride(7, 15, CabRide.PREMIUM), new Ride(2.3, 8, CabRide.PREMIUM), new Ride(0.8, 4, CabRide.PREMIUM) };
        try {
            Assert.assertEquals(new InvoiceSummary(3,  205.5), new InvoiceService().getInvoiceSummary(Arrays.asList(rides)));
        } catch (InvoiceException invoiceException) {
            throw new InvoiceException("Invalid Ride Type", InvoiceException.ExceptionType.INVALID_RIDE_TYPE);
        }
    }

    @Test
    public void givenUserIDForNormalRide_ShouldReturnUserInvoiceSummary() throws InvoiceException {
        invoiceService.addRide(101, Arrays.asList(new Ride(5, 10, CabRide.NORMAL), new Ride(0.3, 1, CabRide.NORMAL), new Ride(1, 5, CabRide.NORMAL)));
        invoiceService.addRide(102, Arrays.asList(new Ride(3, 20, CabRide.NORMAL), new Ride(3, 2, CabRide.NORMAL), new Ride(3.8, 5, CabRide.NORMAL)));
        invoiceService.addRide(103, Arrays.asList(new Ride(6, 5, CabRide.NORMAL), new Ride(1.7, 4, CabRide.NORMAL), new Ride(8.9, 9, CabRide.NORMAL)));
        try {
            Assert.assertEquals(new InvoiceSummary(3, 80), invoiceService.getInvoice(101));
        } catch (InvoiceException invoiceException) {
            throw new InvoiceException("Invalid User ID", InvoiceException.ExceptionType.INVALID_USER_ID);
        }
    }

}
