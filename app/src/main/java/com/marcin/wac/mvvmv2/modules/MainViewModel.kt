package com.marcin.wac.mvvmv2.modules

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.marcin.wac.mvvmv2.data.JokeRepository
import com.marcin.wac.mvvmv2.data.models.JokeResponse

class MainViewModel ()
    : ViewModel() {

    private var jokeRepository: JokeRepository? = null
    private var jokeResponseLiveData: LiveData<JokeResponse?>? = null

    init {
        jokeRepository = JokeRepository()
        jokeResponseLiveData = jokeRepository!!.getJokes()
    }

    fun getJokeResponseLiveData(): LiveData<JokeResponse?>? {
        return jokeResponseLiveData
    }
}