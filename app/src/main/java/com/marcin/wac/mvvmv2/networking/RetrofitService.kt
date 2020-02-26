package com.marcin.wac.mvvmv2.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object{
        private var retrofit = Retrofit.Builder()
            .baseUrl("http://api.icndb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun <S> createService(serviceClass: Class<S>?): S {
            return retrofit.create(serviceClass!!)
        }
    }
}