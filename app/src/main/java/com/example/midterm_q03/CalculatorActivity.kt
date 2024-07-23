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

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_calculator)

        val num1Input = findViewById<EditText>(id.num1Input)
        val num2Input = findViewById<EditText>(id.num2Input)
        val spinner = findViewById<Spinner>(id.spinner)
        val button = findViewById<Button>(id.button)

        val operations = arrayOf("Add", "Subtract", "Multiply", "Divide")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        button.setOnClickListener {
            val num1 = num1Input.text.toString().toDoubleOrNull()
            val num2 = num2Input.text.toString().toDoubleOrNull()
            val operation = spinner.selectedItem.toString()

            if (num1 != null && num2 != null) {
                val result = when (operation) {
                    "Add" -> num1 + num2
                    "Subtract" -> num1 - num2
                    "Multiply" -> num1 * num2
                    "Divide" -> if (num2 != 0.0) num1 / num2 else "Error: Division by zero"
                    else -> "Invalid Operation"
                }

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("result", result.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

