package com.lxoms.network.utils

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.lxoms.network.constants.ServerApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * @date      2020/9/4
 * @author    Pengshuwen
 * @describe
 */
object HttpManager {


    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ServerApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }


    fun <T> create(service: Class<T>): T {
        return getRetrofit().create(service)
    }


}