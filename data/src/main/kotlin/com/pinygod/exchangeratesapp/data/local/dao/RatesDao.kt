package com.pinygod.exchangeratesapp.data.local.dao

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pinygod.exchangeratesapp.data.local.dbo.RateDbo
import kotlinx.coroutines.flow.Flow

@Dao
interface RatesDao {

    @Query(
        "SELECT * FROM rate " +
                "WHERE isFavorite >= CASE WHEN :favoritesOnly = 0 THEN 0 ELSE 1 END " +
                "ORDER BY " +
                "CASE WHEN :sort = 'name' AND :sortDirection = 0 THEN name END DESC, " +
                "CASE WHEN :sort = 'name' AND :sortDirection = 1 THEN name END ASC, " +
                "CASE WHEN :sort = 'value' AND :sortDirection = 0 THEN value END DESC, " +
                "CASE WHEN :sort = 'value' AND :sortDirection = 1 THEN value END ASC"
    )
    fun getRates(
        sort: String,
        sortDirection: Int,
        favoritesOnly: Int = 0
    ): PagingSource<Int, RateDbo>

    @Query("SELECT name FROM rate WHERE isFavorite")
    suspend fun getFavoriteRatesNames(): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rates: List<RateDbo>)

    @Query("UPDATE rate SET isFavorite = NOT isFavorite WHERE name = :name")
    suspend fun changeIsFavorite(name: String)
}