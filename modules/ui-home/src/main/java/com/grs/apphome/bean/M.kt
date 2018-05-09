package com.grs.apphome.bean

import java.util.*

/**
 * @作者:gaoruishan
 * @时间:2018/4/26/11:05
 * @邮箱:grs0515@163.com
 */
class M {

    private val name: String? = null
    private val list: List<String>? = null

    fun getName(): String {
        return name ?: ""
    }

    fun getList(): List<String> {
        return list ?: ArrayList()
    }
}
