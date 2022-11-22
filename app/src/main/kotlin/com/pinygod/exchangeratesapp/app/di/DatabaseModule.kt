package com.pinygod.exchangeratesapp.app.di

import android.content.Context
import com.pinygod.exchangeratesapp.data.local.DataStore
import com.pinygod.exchangeratesapp.data.local.AppDatabase
import com.pinygod.exchangeratesapp.data.local.createDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideRatesDao(database: AppDatabase) = database.ratesDao()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) =
        createDatabase(appContext = context)

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context) =
        DataStore(context = context)
}