package com.certified.zuritask40helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIncrease: Button = findViewById(R.id.btn_increase)
        val tvCount: TextView = findViewById(R.id.tv_count)

        btnIncrease.setOnClickListener {
            val currentCount = tvCount.text.toString().toInt()
            val nextCount = currentCount + 1
            tvCount.text = nextCount.toString()
        }
    }
}