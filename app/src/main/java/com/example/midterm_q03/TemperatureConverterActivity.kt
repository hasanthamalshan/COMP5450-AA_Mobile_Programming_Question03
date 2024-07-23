package com.example.midterm_q03

import android.content.Intent
import android.os.Bundle
import android.widget.*
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.midterm_q03.R.*


class TemperatureConverterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_temperature_converter)

        val tempInput = findViewById<EditText>(id.tempInput)
        val spinner = findViewById<Spinner>(id.spinner)
        val button = findViewById<Button>(id.button)

        val units = arrayOf("Celsius to Fahrenheit", "Fahrenheit to Celsius", "Celsius to Kelvin", "Kelvin to Celsius")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        button.setOnClickListener {
            val temp = tempInput.text.toString().toDoubleOrNull()
            val selectedUnit = spinner.selectedItem.toString()

            if (temp != null) {
                val result = when (selectedUnit) {
                    "Celsius to Fahrenheit" -> celsiusToFahrenheit(temp)
                    "Fahrenheit to Celsius" -> fahrenheitToCelsius(temp)
                    "Celsius to Kelvin" -> celsiusToKelvin(temp)
                    "Kelvin to Celsius" -> kelvinToCelsius(temp)
                    else -> "Invalid Conversion"
                }

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("result", result.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter a valid temperature", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun celsiusToFahrenheit(celsius: Double): Double {
        return (celsius * 9/5) + 32
    }

    private fun fahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5/9
    }

    private fun celsiusToKelvin(celsius: Double): Double {
        return celsius + 273.15
    }

    private fun kelvinToCelsius(kelvin: Double): Double {
        return kelvin - 273.15
    }
}

