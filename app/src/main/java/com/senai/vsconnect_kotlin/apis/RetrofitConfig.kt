package com.senai.vsconnect_kotlin.apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    companion object {
        fun obterInstanciaRetrofit(url: String = "http://172.16.26.36:8080/"): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}