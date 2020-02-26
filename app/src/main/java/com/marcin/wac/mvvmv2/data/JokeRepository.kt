package com.marcin.wac.mvvmv2.data

import androidx.lifecycle.MutableLiveData
import com.marcin.wac.mvvmv2.data.models.JokeResponse
import com.marcin.wac.mvvmv2.networking.RetrofitService
import com.marcin.wac.mvvmv2.utilities.api.JokeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeRepository  {

    companion object{
        lateinit var jokeRepository: JokeRepository

        fun getInstance(): JokeRepository{
            if (jokeRepository == null)
                jokeRepository = JokeRepository()
            return jokeRepository
        }
    }

    private lateinit var jokeApi: JokeApi

    fun JokeRepository(){
        jokeApi = RetrofitService.createService(JokeApi::class.java)
    }

    fun getJoke(): MutableLiveData<JokeResponse>{
        val jokeData = MutableLiveData<JokeResponse>()
        jokeApi.getFacts().enqueue(object : Callback<JokeResponse>{

            override fun onResponse(call: Call<JokeResponse>, response: Response<JokeResponse>) {
                if (response.isSuccessful)
                    jokeData.value = response.body()
            }

            override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                jokeData.value = null
            }

        })

        return jokeData
    }
}