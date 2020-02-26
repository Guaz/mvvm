package com.marcin.wac.mvvmv2.utilities.api

import com.marcin.wac.mvvmv2.data.models.JokeResponse
import retrofit2.Call
import retrofit2.http.GET

public interface JokeApi {

    @GET("random/10")
    fun getJokes(): Call<JokeResponse>
}