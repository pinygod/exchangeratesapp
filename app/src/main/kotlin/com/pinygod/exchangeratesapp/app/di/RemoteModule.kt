package com.pinygod.exchangeratesapp.app.di

import com.pinygod.exchangeratesapp.data.remote.createRatesApi
import com.pinygod.exchangeratesapp.data.remote.createRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideRetrofit(converterFactory: Converter.Factory): Retrofit =
        createRetrofit(converterFactory = converterFactory)

    @Singleton
    @Provides
    fun provideRatesApi(retrofit: Retrofit) = createRatesApi(retrofit = retrofit)

    @Singleton
    @Provides
    fun provideGson(): Converter.Factory = GsonConverterFactory.create()
}