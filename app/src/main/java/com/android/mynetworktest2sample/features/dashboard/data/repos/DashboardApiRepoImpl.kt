package com.android.mynetworktest2sample.features.dashboard.data.repos

import com.android.mynetworktest2sample.features.dashboard.data.network.DashboardService
import com.android.mynetworktest2sample.features.dashboard.data.network.models.response.DashboardResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class DashboardApiRepoImpl @Inject constructor(private val dashboardService: DashboardService) {

    suspend fun fetchDummyData(): Response<DashboardResponse> {
        return dashboardService.fetchDummyData()
    }
}
