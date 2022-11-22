package com.pinygod.exchangeratesapp.data.local.dbo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pinygod.exchangeratesapp.domain.entity.Rate
import java.math.BigDecimal

@Entity(tableName = "rate")
data class RateDbo(
    @PrimaryKey val name: String,
    val value: Double,
    var isFavorite: Boolean
)

fun RateDbo.toDomain() = Rate(
    name = name,
    value = value,
    isFavorite = isFavorite
)