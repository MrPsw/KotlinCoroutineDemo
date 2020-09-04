package com.lxoms.kotlincoroutinedemo.data.model

import java.io.Serializable

class BaseResult<T> : Serializable {
    var code = 0
    var msg: String? = null
    var data: T? = null

    override fun toString(): String {
        return "BaseResult(code=$code, msg=$msg, data=$data)"
    }

}