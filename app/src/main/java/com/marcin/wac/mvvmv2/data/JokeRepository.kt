package com.marcin.wac.mvvmv2.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.marcin.wac.mvvmv2.data.models.JokeResponse
import com.marcin.wac.mvvmv2.networking.RetrofitRequest
import com.marcin.wac.mvvmv2.utilities.api.JokeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeRepository {
    private var apiRequest: JokeApi = RetrofitRequest.retrofitInstance!!.create(JokeApi::class.java)
    fun getJokes(): LiveData<JokeResponse?> {
        var data: MutableLiveData<JokeResponse?> = MutableLiveData()
        apiRequest.getJokes()
            .enqueue(object : Callback<JokeResponse?> {
                override fun onResponse(
                    call: Call<JokeResponse?>,
                    response: Response<JokeResponse?>) {
                    if (response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(
                    call: Call<JokeResponse?>, t: Throwable) {
                    data.value = null }
            })
        return data
    }
}
