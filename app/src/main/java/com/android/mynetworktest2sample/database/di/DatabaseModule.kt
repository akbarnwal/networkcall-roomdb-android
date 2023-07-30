package com.android.mynetworktest2sample.database.di

import android.content.Context
import androidx.room.Room
import com.android.mynetworktest2sample.database.dao.DashboardDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun providesDashboardDao(database: AppDatabase): DashboardDao {
        return database.dashboardDao()
    }
}