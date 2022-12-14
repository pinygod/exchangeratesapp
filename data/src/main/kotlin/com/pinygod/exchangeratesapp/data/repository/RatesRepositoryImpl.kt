package com.pinygod.exchangeratesapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.pinygod.exchangeratesapp.data.local.dao.RatesDao
import com.pinygod.exchangeratesapp.data.local.dbo.toDomain
import com.pinygod.exchangeratesapp.data.remote.RatesApi
import com.pinygod.exchangeratesapp.data.remote.dto.toEntity
import com.pinygod.exchangeratesapp.data.remote.dto.toRates
import com.pinygod.exchangeratesapp.domain.entity.Rate
import com.pinygod.exchangeratesapp.domain.entity.SortType
import com.pinygod.exchangeratesapp.domain.repository.RatesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RatesRepositoryImpl @Inject constructor(
    private val ratesApi: RatesApi,
    private val ratesDao: RatesDao,
    private val ioDispatcher: CoroutineDispatcher,
    private val defaultDispatcher: CoroutineDispatcher,
    private val pagingConfig: PagingConfig
) : RatesRepository {

    override suspend fun fetchRates(base: String) = withContext(ioDispatcher) {
        val latestResponse = ratesApi.getLatest(base = base)
        val favoriteRates = ratesDao.getFavoriteRatesNames()

        val rates = withContext(defaultDispatcher) {
            latestResponse
                .toRates()
                .map { rateDto -> rateDto.toEntity() }
                .apply {
                    filter { rate -> favoriteRates.contains(rate.name) }
                        .forEach { rate -> rate.isFavorite = true }
                }
        }

        ratesDao.insert(rates = rates)
    }

    override fun getRates(sortType: SortType, favoritesOnly: Boolean): Flow<PagingData<Rate>> {
        val favoritesOnly = if (favoritesOnly) 1 else 0
        val sort: String
        val sortDirection: Int

        when (sortType) {
            is SortType.AlphabetAsc -> {
                sort = "name"
                sortDirection = 1
            }
            is SortType.AlphabetDesc -> {
                sort = "name"
                sortDirection = 0
            }
            is SortType.ValueAsc -> {
                sort = "value"
                sortDirection = 1
            }
            is SortType.ValueDesc -> {
                sort = "value"
                sortDirection = 0
            }
        }

        return Pager(
            config = pagingConfig
        ) {
            ratesDao.getRates(
                sort = sort,
                sortDirection = sortDirection,
                favoritesOnly = favoritesOnly
            )
        }.flow.map { pagingData ->
            pagingData.map { rate ->
                rate.toDomain()
            }
        }
    }

    override suspend fun changeIsFavorite(name: String) = withContext(ioDispatcher) {
        ratesDao.changeIsFavorite(name = name)
    }
}