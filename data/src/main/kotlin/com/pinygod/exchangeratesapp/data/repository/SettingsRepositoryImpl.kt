package com.pinygod.exchangeratesapp.data.repository

import com.pinygod.exchangeratesapp.data.local.DataStore
import com.pinygod.exchangeratesapp.domain.repository.SettingsRepository
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(private val dataStore: DataStore) :
    SettingsRepository {

    override suspend fun getLastCurrency(): String? = dataStore.getLastCurrency()

    override suspend fun setLastCurrency(name: String) = dataStore.setLastCurrency(name)
}