package com.android.mynetworktest2sample.database.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.mynetworktest2sample.database.dao.DashboardDao
import com.android.mynetworktest2sample.database.tables.DashboardEntity

//@Database(entities = [City::class], version = 1, exportSchema = false)
@Database(entities = [DashboardEntity::class], version = 3, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun dashboardDao(): DashboardDao

    companion object {
        const val DATABASE_NAME = "app_database"
    }
}