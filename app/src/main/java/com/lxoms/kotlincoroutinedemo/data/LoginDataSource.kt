package com.lxoms.kotlincoroutinedemo.data

import com.lxoms.kotlincoroutinedemo.data.model.Account
import com.lxoms.kotlincoroutinedemo.data.model.BaseResult
import com.lxoms.kotlincoroutinedemo.data.remote.UserService
import com.lxoms.network.utils.HttpManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Response

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {


    //suspend 挂起


    suspend fun login(username: String, password: String): Result<Account?> {

        return handleRequest {
            HttpManager.getRetrofit().create(UserService::class.java).login(username, password)
                .execute()
        }
    }

    private suspend fun <T> handleRequest(request: () -> Response<BaseResult<T>>?): Result<T?> {
        return GlobalScope.async(Dispatchers.IO) {
            val response = request()
            if (response?.isSuccessful == true) {
                Result.Success(response.body()?.data)
            } else {
                Result.Error(ServerException(-100, "服务器异常"))
            }
        }.await()
    }


    class ServerException : Exception {

        constructor()

        constructor(errorCode: Int, errorMsg: String) {
            this.errorCode = errorCode
            this.errorMsg = errorMsg
        }


        var errorCode = 0
        var errorMsg = ""
    }


}