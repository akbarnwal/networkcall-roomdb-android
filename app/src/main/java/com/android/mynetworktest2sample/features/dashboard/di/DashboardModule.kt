package com.android.mynetworktest2sample.features.dashboard.di

import com.android.mynetworktest2sample.database.di.AppDatabase
import com.android.mynetworktest2sample.features.dashboard.data.network.DashboardService
import com.android.mynetworktest2sample.features.dashboard.data.repos.DashboardApiRepoImpl
import com.android.mynetworktest2sample.features.dashboard.data.usecases.DashboardUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DashboardModule {

    @Provides
    fun providesDashboardService(retrofit: Retrofit): DashboardService {
        return retrofit.create(DashboardService::class.java)
    }

    @Provides
    fun providesDashboardRepoImpl(dashboardService: DashboardService): DashboardApiRepoImpl {
        return DashboardApiRepoImpl(dashboardService)
    }

    @Provides
    fun providesDashboardUseCaseImpl(
        dashboardApiRepoImpl: DashboardApiRepoImpl,
        database: AppDatabase
    ): DashboardUseCaseImpl {
        return DashboardUseCaseImpl(dashboardApiRepoImpl, database)
    }
}