package com.example.fullstack.androidapp

import android.icu.text.NumberFormat
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fullstack.shared.TaxCalculator
import com.example.fullstack.shared.TaxRegion

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taxes()
        }
    }
}

@Composable
fun Taxes() {
    val taxRegionState = remember { mutableStateOf(TextFieldValue()) }
    val taxRateState = remember { mutableStateOf<Double?>(null) }

    fun calculateTaxes() {
        taxRateState.value = TaxCalculator.taxRate(TaxRegion(taxRegionState.value.text))
    }

    Column(Modifier.fillMaxWidth().padding(10.dp), Arrangement.Top) {
        Text("Calculate Taxes", modifier = Modifier.padding(top = 50.dp))

        OutlinedTextField(taxRegionState.value, placeholder = { Text("Region") }, onValueChange = { taxRegionState.value = it })

        Button(::calculateTaxes, Modifier.padding(top = 10.dp), enabled = taxRegionState.value.text.isNotEmpty()) {
            Text("Get Rate")
        }

        taxRateState.value?.let {
            val percentFormatter = NumberFormat.getPercentInstance()
            val formatted = percentFormatter.format(it)
            Text("Tax Rate: $formatted")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaxesPreview() {
    Taxes()
}
