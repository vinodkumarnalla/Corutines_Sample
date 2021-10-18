package com.example.corutinessample.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIClient {
    @GET("todos/1")
    fun getJson(): Call<SimpleJsonExample>

    companion object {

        var BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create(): APIClient {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(APIClient::class.java)

        }
    }
}