package com.pinygod.exchangeratesapp.data.remote.dto

import java.math.BigDecimal
import java.util.Date

data class RatesResponse(
    val success: Boolean,
    val timestamp: Long,
    val base: String,
    val date: Date,
    val rates: Map<String, Double>
)

fun RatesResponse.toRates() = rates.map { entry ->
    RateDto(name = entry.key, value = entry.value)
}
