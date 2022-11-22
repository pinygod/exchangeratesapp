package com.pinygod.exchangeratesapp.domain.usecase

import com.pinygod.exchangeratesapp.domain.entity.SortType
import com.pinygod.exchangeratesapp.domain.repository.RatesRepository
import javax.inject.Inject

class GetRatesUseCase @Inject constructor(private val ratesRepository: RatesRepository) {

    operator fun invoke(sortType: SortType, favoriteOnly: Boolean) =
        ratesRepository.getRates(sortType, favoriteOnly)
}