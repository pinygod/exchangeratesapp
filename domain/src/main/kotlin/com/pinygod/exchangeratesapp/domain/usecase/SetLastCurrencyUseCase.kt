package com.pinygod.exchangeratesapp.domain.usecase

import com.pinygod.exchangeratesapp.domain.repository.SettingsRepository
import javax.inject.Inject

class SetLastCurrencyUseCase @Inject constructor(private val settingsRepository: SettingsRepository) {

    suspend operator fun invoke(name: String) = settingsRepository.setLastCurrency(name)
}