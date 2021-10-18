package com.example.corutinessample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.corutinessample.R

class MainActivity : AppCompatActivity() {
    val dataViewModel: DataViewModel by lazy {
        ViewModelProvider(this).get(DataViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataViewModel.fetchJsonInfo()
    }
}