package com.example.corutinessample.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.corutinessample.Failure
import com.example.corutinessample.network.NetworkRepository
import com.example.corutinessample.Success
import kotlinx.coroutines.async

class DataViewModel : ViewModel() {

    fun fetchJsonInfo() {
        viewModelScope.async {
            when (val data = NetworkRepository().getJsonData()) {
                is Success -> {
                    println("DATA->" + data.data.title)
                }
                is Failure -> {
                    println("DATA->" + data.error)
                }
            }
        }

    }

}