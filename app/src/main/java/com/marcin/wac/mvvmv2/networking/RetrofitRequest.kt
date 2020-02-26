package com.marcin.wac.mvvmv2.networking

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitRequest {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://api.icndb.com/"
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                val httpClient = OkHttpClient.Builder()
                httpClient.readTimeout(15, TimeUnit.SECONDS)
                httpClient.addInterceptor(httpLoggingInterceptor)


                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
            }
            return retrofit
        }
}
