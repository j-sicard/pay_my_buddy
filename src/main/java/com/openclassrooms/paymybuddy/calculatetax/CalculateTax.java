package com.openclassrooms.paymybuddy.calculatetax;

import java.math.BigDecimal;

public class CalculateTax {

    public static BigDecimal calculCost(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.5).divide(BigDecimal.valueOf(100.0)));
    }
}
