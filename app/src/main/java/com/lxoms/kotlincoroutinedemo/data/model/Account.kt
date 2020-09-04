package com.lxoms.kotlincoroutinedemo.data.model

import java.io.Serializable
import java.util.*

class Account : Serializable {
    var id = 0
    var name: String? = null
    var passWord: String? = null
    var phone: String? = null
    var createTime: Long? = null

    override fun toString(): String {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                '}'
    }

}