package com.certified.zuritask40helloworld.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.certified.zuritask40helloworld.R
import com.certified.zuritask40helloworld.util.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainActivityViewModel(this.application)
        val btnIncrease: Button = findViewById(R.id.btn_increase)
        val tvCount: TextView = findViewById(R.id.tv_count)

        tvCount.text = "0"

        btnIncrease.setOnClickListener {
            viewModel.increment(tvCount)
        }
    }
}