package com.jkgug.meli_juanc.di.remote

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.jkgug.meli_juanc.data.remote.dto.error.ErrorResponseDto
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val time1 = System.nanoTime()
        Log.d("LoggingInterceptor", "Sending request ${request.url()}")
        val response = chain.proceed(request)
        val time2 = System.nanoTime()
        Log.d(
            "LoggingInterceptor",
            "Received response for ${request.url()} in ${(time2 - time1) / 1e6}ms"
        )
        return response
    }
}

class ErrorInterceptor : Interceptor {

    override fun intercept(
        chain: Interceptor.Chain
    ): Response {
        val request = chain.request()
        val response: Response = chain.proceed(request)
        if (!response.isSuccessful) {
            val errorBody = response.peekBody(2048).string()
            val gson = Gson()
            try {
                val errorResponse = gson.fromJson(errorBody, ErrorResponseDto::class.java)
                Log.d("ErrorInterceptor", errorResponse.message)
                throw IOException(errorResponse.message)
            } catch (jsonSyntaxException: JsonSyntaxException) {
                Log.d(
                    "ErrorInterceptor",
                    "intercept: Error to parse JSON: $jsonSyntaxException"
                )
            }
        }
        return response
    }
}