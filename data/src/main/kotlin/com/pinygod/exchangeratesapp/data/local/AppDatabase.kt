package com.pinygod.exchangeratesapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pinygod.exchangeratesapp.data.local.dao.RatesDao
import com.pinygod.exchangeratesapp.data.local.dbo.RateDbo

@Database(
    entities = [RateDbo::class],
    version = 1,
    autoMigrations = []
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun ratesDao(): RatesDao
}

fun createDatabase(appContext: Context): AppDatabase =
    Room.databaseBuilder(appContext, AppDatabase::class.java, "AppDatabase").build()