package com.example.midterm_q03

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.midterm_q03.R.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculatorButton = findViewById<Button>(R.id.calculatorButton)
        val tempConverterButton = findViewById<Button>(R.id.tempConverterButton)

        calculatorButton.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        tempConverterButton.setOnClickListener {
            val intent = Intent(this, TemperatureConverterActivity::class.java)
            startActivity(intent)
        }
    }
}
