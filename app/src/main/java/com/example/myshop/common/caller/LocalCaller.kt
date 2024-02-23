package com.example.myshop.common.caller

import android.util.Log
import com.example.myshop.R
import com.example.myshop.common.Response

suspend inline fun <T> dbCall(crossinline call: suspend () -> T): Response<T> {
    return try {
        Response.Success(data = call())
    } catch (e: Exception) {
        Log.d("DB CALL EXCEPTION", e.stackTraceToString())
        Response.Error(errorMessageId = R.string.unknown_error)
    }
}