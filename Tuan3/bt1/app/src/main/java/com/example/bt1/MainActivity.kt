package com.example.bt1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtChange = findViewById<EditText>(R.id.edtChange)
        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener{
            edtChange.setText("Van Truong")
        }

    }
}