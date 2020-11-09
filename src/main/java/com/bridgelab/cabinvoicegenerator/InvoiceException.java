package com.bridgelab.cabinvoicegenerator;

public class InvoiceException extends Throwable {

    public enum ExceptionType {
        INVALID_RIDE_TYPE, INVALID_USER_ID
    }

    ExceptionType exceptionType;

    public InvoiceException(String message, ExceptionType exceptionType) {
        super(message);
        this.exceptionType = exceptionType;
    }

}
