package com.example.fullstack.shared

import kotlin.test.Test
import kotlin.test.assertEquals

class TaxesTest {

    @Test
    fun rate_should_work() {
        assertEquals(TaxCalculator.taxRate(TaxRegion("a")), 0.0)
        assertEquals(TaxCalculator.taxRate(TaxRegion("aa")), 0.0)
        assertEquals(TaxCalculator.taxRate(TaxRegion("A")), 0.0)
        assertEquals(TaxCalculator.taxRate(TaxRegion("AA")), 0.0)
        assertEquals(TaxCalculator.taxRate(TaxRegion("z")), 0.25)
        assertEquals(TaxCalculator.taxRate(TaxRegion("ZZ")), 0.25)
        assertEquals(TaxCalculator.taxRate(TaxRegion("aZ")), 0.12)
    }

}
