package com.example.cointracker.extensions

import android.util.Log
import java.text.SimpleDateFormat
import  java.util.*


inline fun <reified T : Any> clas() = T::class.java

inline fun <reified T : Any> tag() = T::class.java.simpleName

fun String.safeToLong(): Long {
    return  this.toLongOrNull() ?: 0L
}

fun Long.unixToDate(pattern: String = "dd MMM YYYY, HH:mm:ss") : String{
    val date = Date(this * 1000L)
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    return sdf.format(date)
}

fun String.trimTrailingZeros(): String?{
    return if ( !this.contains('.')){
        this
    }else{
        this.replace("\\.?0*$".toRegex(), "")
    }
}