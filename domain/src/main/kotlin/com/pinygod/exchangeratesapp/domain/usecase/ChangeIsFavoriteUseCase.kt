package com.pinygod.exchangeratesapp.domain.usecase

import com.pinygod.exchangeratesapp.domain.repository.RatesRepository
import javax.inject.Inject

class ChangeIsFavoriteUseCase @Inject constructor(private val ratesRepository: RatesRepository) {

    suspend operator fun invoke(name: String) = ratesRepository.changeIsFavorite(name)
}