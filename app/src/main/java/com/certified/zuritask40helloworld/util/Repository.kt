package com.certified.zuritask40helloworld.util

import android.app.Application
import android.widget.TextView
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Repository(application: Application) {

    lateinit var lastCount: LiveData<Int>

    companion object {
        val executor: ExecutorService = Executors.newSingleThreadExecutor()
    }

    fun increment(tvCount: TextView) {
        val currentCount = tvCount.text.toString().toInt()
        val nextCount = currentCount + 1
        tvCount.text = nextCount.toString()
//        lastCount = nextCount.toString.toInt()
    }
}