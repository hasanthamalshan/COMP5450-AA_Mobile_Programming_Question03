package com.example.midterm_q03
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.midterm_q03.R.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_result)

        val result = intent.getStringExtra("result")
        val resultTextView = findViewById<TextView>(id.resultTextView)
        resultTextView.text = result
    }
}

