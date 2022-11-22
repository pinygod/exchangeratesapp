package com.pinygod.exchangeratesapp.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStore @Inject constructor(private val context: Context) {

    private object Keys {
        val lastCurrency = stringPreferencesKey(name = "last_currency")
    }

    private val Context.dataStore by preferencesDataStore(
        name = "user_preference"
    )

    suspend fun getLastCurrency() = context.dataStore.data.map { preferences ->
        preferences[Keys.lastCurrency]
    }.first()

    suspend fun setLastCurrency(name: String) {
        context.dataStore.edit { preferences ->
            preferences[Keys.lastCurrency] = name
        }
    }
}