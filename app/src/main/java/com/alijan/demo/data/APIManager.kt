package com.alijan.demo.data

import com.alijan.demo.data.model.PrayResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIManager {

    @GET("pray/all")
    suspend fun getPrayDate(@Query("data.city") city: String): Response<PrayResponse>

}