package com.bridgelab.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        int distance = 10, time = 12;
        int totalFare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(112, totalFare);
    }

}
