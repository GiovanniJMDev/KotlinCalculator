package com.example.kotlincalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlincalculator.ui.theme.KotlinCalculatorTheme
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorApp()
                }
            }
        }
    }
}

@Composable
fun CalculatorApp() {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var errorMessage1 by remember { mutableStateOf<String?>(null) } // Error para el campo 1
    var errorMessage2 by remember { mutableStateOf<String?>(null) } // Error para el campo 2

    fun isValidNumber(input: String): Boolean {
        return input.matches(Regex("^-?\\d*\\.?\\d*$")) // Permite números y un solo punto decimal
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        // Campo de texto para el primer número
        OutlinedTextField(
            value = number1,
            onValueChange = { newValue ->
                if (isValidNumber(newValue)) {
                    number1 = newValue
                    errorMessage1 = null // Limpiar el mensaje de error al cambiar el valor
                } else {
                    errorMessage1 = "Número 1 no es válido"
                }
            },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth(),
            isError = errorMessage1 != null,
            supportingText = {
                if (errorMessage1 != null) {
                    Text(text = errorMessage1!!, color = MaterialTheme.colorScheme.error)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para el segundo número
        OutlinedTextField(
            value = number2,
            onValueChange = { newValue ->
                if (isValidNumber(newValue)) {
                    number2 = newValue
                    errorMessage2 = null // Limpiar el mensaje de error al cambiar el valor
                } else {
                    errorMessage2 = "Número 2 no es válido"
                }
            },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth(),
            isError = errorMessage2 != null,
            supportingText = {
                if (errorMessage2 != null) {
                    Text(text = errorMessage2!!, color = MaterialTheme.colorScheme.error)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Validar que ambos campos tengan datos
                if (number1.isEmpty()) {
                    errorMessage1 = "Este campo es obligatorio"
                }
                if (number2.isEmpty()) {
                    errorMessage2 = "Este campo es obligatorio"
                }

                // Si ambos campos tienen datos, realizar la suma
                if (number1.isNotEmpty() && number2.isNotEmpty()) {
                    try {
                        val num1 = number1.toBigDecimalOrNull() ?: BigDecimal.ZERO
                        val num2 = number2.toBigDecimalOrNull() ?: BigDecimal.ZERO

                        // Realizar la suma
                        val sum = num1 + num2

                        // Determinar la cantidad de decimales del número con más decimales
                        val decimalPlaces1 = if (number1.contains(".")) number1.substringAfter(".").length else 0
                        val decimalPlaces2 = if (number2.contains(".")) number2.substringAfter(".").length else 0
                        val maxDecimalPlaces = maxOf(decimalPlaces1, decimalPlaces2)

                        // Redondear el resultado
                        val roundedResult = sum.setScale(maxDecimalPlaces, RoundingMode.HALF_UP)

                        // Almacenar el resultado como String
                        result = roundedResult.toString()
                    } catch (e: Exception) {
                        result = "Error: ${e.message}"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sumar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Resultado: $result",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorAppPreview() {
    KotlinCalculatorTheme {
        CalculatorApp()
    }
}