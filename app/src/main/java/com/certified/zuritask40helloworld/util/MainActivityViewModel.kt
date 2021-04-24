package com.certified.zuritask40helloworld.util

import android.app.Application
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    private val repository = Repository(application)

    fun increment(tvCount: TextView) {
        repository.increment(tvCount)
    }
}