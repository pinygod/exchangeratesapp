package com.pinygod.exchangeratesapp.data.remote

import com.pinygod.exchangeratesapp.data.BuildConfig
import retrofit2.Converter
import retrofit2.Retrofit

fun createRetrofit(converterFactory: Converter.Factory): Retrofit = Retrofit
    .Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .addConverterFactory(converterFactory)
    .build()

fun createRatesApi(retrofit: Retrofit): RatesApi = retrofit.create(RatesApi::class.java)