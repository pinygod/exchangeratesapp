package com.pinygod.exchangeratesapp.data.remote.dto

import com.pinygod.exchangeratesapp.data.local.dbo.RateDbo
import java.math.BigDecimal

data class RateDto(
    val name: String,
    val value: Double
)

fun RateDto.toEntity() = RateDbo(name = name, value = value, isFavorite = false)