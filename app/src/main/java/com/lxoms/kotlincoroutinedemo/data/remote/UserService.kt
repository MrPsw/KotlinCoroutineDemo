package com.lxoms.kotlincoroutinedemo.data.remote

import com.lxoms.kotlincoroutinedemo.data.model.Account
import com.lxoms.kotlincoroutinedemo.data.model.BaseResult
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


/**
 * @date      2020/9/4
 * @author    Pengshuwen
 * @describe
 */

@JvmSuppressWildcards
interface UserService {


    /**
     * 登录
     */
    @POST("api/Account/login1")
    @FormUrlEncoded
    fun login(
        @Field("phone") phone: String,
        @Field("token") token: String
    ): Call<BaseResult<Account>>




}