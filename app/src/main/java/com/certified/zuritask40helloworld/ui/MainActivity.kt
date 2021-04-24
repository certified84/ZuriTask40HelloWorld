package com.certified.zuritask40helloworld.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.certified.zuritask40helloworld.R
import com.certified.zuritask40helloworld.util.MainActivityViewModel
import com.certified.zuritask40helloworld.util.PreferenceKeys
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainActivityViewModel(this.application)
        val btnIncrease: Button = findViewById(R.id.btn_increase)
        val tvCount: TextView = findViewById(R.id.tv_count)
        val switchDarkMode: SwitchMaterial = findViewById(R.id.switch_dark_mode)

        isDarkModeEnabled()

        val preferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(this.applicationContext)
        val nightMode = preferences.getBoolean(PreferenceKeys.DARK_MODE, false)
        switchDarkMode.isChecked = nightMode
        switchDarkMode.setOnClickListener {
            if (switchDarkMode.isChecked) {
                val editor = preferences.edit()
                editor.putBoolean(PreferenceKeys.DARK_MODE, true)
                editor.apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                val editor = preferences.edit()
                editor.putBoolean(PreferenceKeys.DARK_MODE, false)
                editor.apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        tvCount.text = "0"

        btnIncrease.setOnClickListener {
            viewModel.increment(tvCount)
        }
    }

    private fun isDarkModeEnabled() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val isDarkModeEnabled = preferences.getBoolean(PreferenceKeys.DARK_MODE, false)
        if (isDarkModeEnabled)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}