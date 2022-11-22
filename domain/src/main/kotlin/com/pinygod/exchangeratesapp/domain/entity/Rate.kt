package com.pinygod.exchangeratesapp.domain.entity

import java.math.BigDecimal

data class Rate(
    val name: String,
    val value: Double,
    val isFavorite: Boolean
)