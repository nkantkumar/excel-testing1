package com.puretech.payment;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    /**
     * This class tests the pay method of the PaymentService class.
     * The pay method takes a payment amount and delegates the charge to the PaymentGateway.
     * The method returns true if the charge is successful and false otherwise.
     */

    @Test
    void testPayReturnsTrueWhenChargeSuccessful() {
        // Arrange
        PaymentGateway gatewayMock = mock(PaymentGateway.class);
        when(gatewayMock.charge(100.0)).thenReturn(true);
        PaymentService paymentService = new PaymentService(gatewayMock);

        // Act
        boolean result = paymentService.pay(100.0);

        // Assert
        assertTrue(result, "PaymentService should return true when charge is successful");
        verify(gatewayMock).charge(100.0);
    }

    @Test
    void testPayReturnsFalseWhenChargeFails() {
        // Arrange
        PaymentGateway gatewayMock = mock(PaymentGateway.class);
        when(gatewayMock.charge(100.0)).thenReturn(false);
        PaymentService paymentService = new PaymentService(gatewayMock);

        // Act
        boolean result = paymentService.pay(100.0);

        // Assert
        assertFalse(result, "PaymentService should return false when charge fails");
        verify(gatewayMock).charge(100.0);
    }
}