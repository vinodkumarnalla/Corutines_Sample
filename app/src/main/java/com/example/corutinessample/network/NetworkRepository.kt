package com.example.corutinessample.network

import com.example.corutinessample.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class NetworkRepository {

    suspend fun getJsonData(): Result<SimpleJsonExample> {
        return getResult(APIClient.create().getJson())
    }

    suspend fun <T : Any> getResult(call: Call<T>): Result<T> = suspendCoroutine {
        call.enqueue(object : Callback<T> {

            override fun onFailure(call: Call<T>?, error: Throwable?) = it.resume(Failure(error))

            override fun onResponse(call: Call<T>?, response: Response<T>?) {
                response?.body()?.run { it.resume(Success(this)) }
                response?.errorBody()?.run { it.resume(Failure(HttpException(response))) }
            }
        })
    }
}