package com.openclassrooms.paymybuddy.utils;

import java.math.BigDecimal;

public class Utils {

    public static BigDecimal calculCost(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.5).divide(BigDecimal.valueOf(100.0)));
    }
}
