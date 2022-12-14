package com.pinygod.exchangeratesapp.app.di

import androidx.paging.PagingConfig
import com.pinygod.exchangeratesapp.data.utils.DefaultPagingConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilsModule {

    @Provides
    @Singleton
    @DefaultPagingConfig
    fun provideDefaultPagingConfig() = PagingConfig(
        pageSize = 20,
        prefetchDistance = 5
    )
}