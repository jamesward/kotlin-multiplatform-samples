package com.example.fullstack.webapp

import com.example.fullstack.shared.TaxCalculator
import com.example.fullstack.shared.TaxRegion
import kotlinx.browser.document
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.dom.create
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onInputFunction
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLInputElement
import kotlin.math.roundToInt

fun main() {
    val body = document.body ?: error("No body")

    val taxRateP = document.create.p { }

    body.append {
        div {
            p {
                +"Tax Calculator"
            }
            textInput {
                id = "taxRegion"
                placeholder = "Region"
                onInputFunction = {
                    (document.getElementById("getTaxes") as HTMLButtonElement).disabled = (it.target as HTMLInputElement).value.isEmpty()
                }
            }
            button {
                id = "getTaxes"
                disabled = true
                +"Get Taxes"
                onClickFunction = {
                    val taxRegion = (document.getElementById("taxRegion") as HTMLInputElement).value
                    val taxRate = (TaxCalculator.taxRate(TaxRegion(taxRegion)) * 100).roundToInt()
                    taxRateP.textContent = "Tax Rate $taxRate%"
                }
            }
        }.append(taxRateP)
    }
}
