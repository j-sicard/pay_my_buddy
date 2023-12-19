package com.openclassrooms.paymybuddy.calculatetax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.openclassrooms.paymybuddy.AbstractConfigurationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

class CalculateTaxTest extends AbstractConfigurationTest {

    @Autowired
    CalculateTax calculateTax;

/*    @Test
    public void testCalculCost() {
     assertEquals(BigDecimal.valueOf(0.5), calculateTax.calculCost(BigDecimal.valueOf(100.0)));
        System.out.println(CalculateTax.calculCost(BigDecimal.valueOf(100.0)));

    }*/
}
