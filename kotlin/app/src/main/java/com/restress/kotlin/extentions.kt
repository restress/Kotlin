package com.restress.kotlin

import com.squareup.moshi.Moshi
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by win10 on 2017/12/12.
 */
fun String.formatDate():String{
    val initialFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.ENGLISH)
    val format = SimpleDateFormat("yyyy-M-dd",Locale.US)
    val date = initialFormat.parse(this)
    return format(date).toString()
}

//TODO 我不太懂你要干什么
inline fun <reified T> Moshi.fromJson(json: String): T = this.adapter(T::class.java).fromJson(json)