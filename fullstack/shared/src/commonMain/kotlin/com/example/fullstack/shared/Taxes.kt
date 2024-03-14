package com.example.fullstack.shared

data class TaxRegion(val id: String)

object TaxCalculator {
    // the best tax policy is one where the closer to Z, the higher the taxes; where Z = 25% because Z is the 25th letter (zero-based)
    fun taxRate(taxRegion: TaxRegion): Double = run {
        taxRegion.id.uppercase().sumOf {
            it.code.coerceIn('A'.code, 'Z'.code) - 65
        } / taxRegion.id.uppercase().length / 100.0
    }
}
