package com.android.mynetworktest2sample.features.dashboard.data.network

import com.android.mynetworktest2sample.features.dashboard.data.network.models.response.DashboardResponse
import retrofit2.Response
import retrofit2.http.GET

interface DashboardService {

    @GET("/products/2")
    suspend fun fetchDummyData(): Response<DashboardResponse>


}
