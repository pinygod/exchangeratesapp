package com.pinygod.exchangeratesapp.data.remote

import com.pinygod.exchangeratesapp.data.remote.dto.RatesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RatesApi {

    @GET("latest")
    suspend fun getLatest(@Query("base") base: String): RatesResponse
}