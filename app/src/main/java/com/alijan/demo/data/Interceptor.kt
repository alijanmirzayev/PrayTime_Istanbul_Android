package com.alijan.demo.data

import okhttp3.Interceptor
import okhttp3.Response

class Interceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val auth = request.newBuilder()
            .header("authorization","apikey 630IVGZcKb3ro1HNdTr28y:6IFCZy6yz5AiEEOcxJ5PA6")
            .build()
        return chain.proceed(auth)
    }
}