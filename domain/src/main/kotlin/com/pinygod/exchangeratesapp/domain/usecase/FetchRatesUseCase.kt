package com.pinygod.exchangeratesapp.domain.usecase

import com.pinygod.exchangeratesapp.domain.repository.RatesRepository
import com.pinygod.exchangeratesapp.domain.utils.processRequest
import javax.inject.Inject

class FetchRatesUseCase @Inject constructor(private val ratesRepository: RatesRepository) {

    suspend operator fun invoke(base: String) = processRequest { ratesRepository.fetchRates(base) }
}