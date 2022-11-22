package com.pinygod.exchangeratesapp.domain.repository

import com.pinygod.exchangeratesapp.domain.entity.SortType
import com.pinygod.exchangeratesapp.domain.entity.Rate
import kotlinx.coroutines.flow.Flow

interface RatesRepository {

    suspend fun fetchRates(base: String)
    fun getRates(sortType: SortType, favoritesOnly: Boolean): Flow<List<Rate>>
    suspend fun changeIsFavorite(name: String)
}