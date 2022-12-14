package com.pinygod.exchangeratesapp.app.di

import androidx.paging.PagingConfig
import com.pinygod.exchangeratesapp.data.local.DataStore
import com.pinygod.exchangeratesapp.data.local.dao.RatesDao
import com.pinygod.exchangeratesapp.data.remote.RatesApi
import com.pinygod.exchangeratesapp.data.repository.RatesRepositoryImpl
import com.pinygod.exchangeratesapp.data.repository.SettingsRepositoryImpl
import com.pinygod.exchangeratesapp.data.utils.DefaultPagingConfig
import com.pinygod.exchangeratesapp.domain.repository.RatesRepository
import com.pinygod.exchangeratesapp.domain.repository.SettingsRepository
import com.pinygod.exchangeratesapp.domain.utils.DefaultDispatcher
import com.pinygod.exchangeratesapp.domain.utils.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRatesRepository(
        ratesApi: RatesApi,
        ratesDao: RatesDao,
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        @DefaultDispatcher defaultDispatcher: CoroutineDispatcher,
        @DefaultPagingConfig defaultPagingConfig: PagingConfig
    ): RatesRepository =
        RatesRepositoryImpl(
            ratesApi = ratesApi,
            ratesDao = ratesDao,
            ioDispatcher = ioDispatcher,
            defaultDispatcher = defaultDispatcher,
            pagingConfig = defaultPagingConfig
        )

    @Provides
    @ViewModelScoped
    fun provideSettingsRepository(dataStore: DataStore): SettingsRepository =
        SettingsRepositoryImpl(dataStore = dataStore)
}