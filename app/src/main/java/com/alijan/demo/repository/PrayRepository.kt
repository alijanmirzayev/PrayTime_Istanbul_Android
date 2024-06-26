package com.alijan.demo.repository

import com.alijan.demo.data.APIManager
import com.alijan.demo.util.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PrayRepository @Inject constructor(private val apiManager: APIManager) {

    suspend fun getPrayDate(city: String) = withContext(Dispatchers.IO) {
        try {
            val response = apiManager.getPrayDate(city)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@withContext NetworkResponse.Success(it.result)
                }
            } else {
                return@withContext NetworkResponse.Error(response.errorBody().toString())
            }
        } catch (e: Exception) {
            return@withContext NetworkResponse.Error(e.localizedMessage?.toString())
        }
    }

}