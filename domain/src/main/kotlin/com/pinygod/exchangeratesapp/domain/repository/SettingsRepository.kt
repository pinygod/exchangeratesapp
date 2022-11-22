package com.pinygod.exchangeratesapp.domain.repository

interface SettingsRepository {

    suspend fun getLastCurrency(): String?
    suspend fun setLastCurrency(name: String)
}