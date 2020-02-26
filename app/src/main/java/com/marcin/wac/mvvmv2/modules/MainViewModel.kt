package com.marcin.wac.mvvmv2.modules

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marcin.wac.mvvmv2.data.JokeRepository
import com.marcin.wac.mvvmv2.data.models.JokeResponse

class MainViewModel ()
    : ViewModel() {

    private var mutableLiveData: MutableLiveData<JokeResponse>? = null
    private lateinit var jokeRepository: JokeRepository

    fun init(){
        if (mutableLiveData != null){
            return
        }

        jokeRepository = JokeRepository.getInstance()
        mutableLiveData = jokeRepository.getJoke()

    }

    fun getNewRepository() = mutableLiveData

}