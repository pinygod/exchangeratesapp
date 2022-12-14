package com.pinygod.exchangeratesapp.domain.repository

import androidx.paging.PagingData
import com.pinygod.exchangeratesapp.domain.entity.SortType
import com.pinygod.exchangeratesapp.domain.entity.Rate
import kotlinx.coroutines.flow.Flow

interface RatesRepository {

    suspend fun fetchRates(base: String)
    fun getRates(sortType: SortType, favoritesOnly: Boolean): Flow<PagingData<Rate>>
    suspend fun changeIsFavorite(name: String)
}