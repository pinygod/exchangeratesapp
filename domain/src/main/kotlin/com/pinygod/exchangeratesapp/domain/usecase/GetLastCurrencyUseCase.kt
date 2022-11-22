package com.pinygod.exchangeratesapp.domain.usecase

import com.pinygod.exchangeratesapp.domain.repository.SettingsRepository
import javax.inject.Inject

class GetLastCurrencyUseCase @Inject constructor(private val settingsRepository: SettingsRepository) {

    suspend operator fun invoke() = settingsRepository.getLastCurrency()
}