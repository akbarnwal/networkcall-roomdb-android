package com.android.mynetworktest2sample.features.dashboard.data.usecases

import com.android.mynetworktest2sample.database.di.AppDatabase
import com.android.mynetworktest2sample.database.tables.DashboardEntity
import com.android.mynetworktest2sample.features.dashboard.data.network.models.response.DashboardResponse
import com.android.mynetworktest2sample.features.dashboard.data.repos.DashboardApiRepoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DashboardUseCaseImpl @Inject constructor(
    private val repo: DashboardApiRepoImpl,
    private val database: AppDatabase
) {
    private val dao = database.dashboardDao()

    suspend fun fetchDashboardData(): List<DashboardEntity> {
        return withContext(Dispatchers.IO) {
            val response = repo.fetchDummyData()
            return@withContext if (response.isSuccessful) {
                val dashboardEntities = convertResponseRecordAndReturnDBList(response.body())
                dashboardEntities

            } else {
                emptyList()
            }
        }
    }

    private suspend fun convertResponseRecordAndReturnDBList(response: DashboardResponse?): List<DashboardEntity> {
        response?.apply {
            //Save to the table
            val dashboardEntity = DashboardEntity(
                id = id,
                title = title,
                desc = description,
                price = price
            )
            dao.insertDashboardRecord(dashboardEntity)

            return dao.getAllDashboardRecords()
        }
        return emptyList()
    }

    suspend fun deleteRecord(uId: Long): List<DashboardEntity> {
        return withContext(Dispatchers.IO){
            val recordDeleted  = dao.deleteDashboardRecordById(uId)
//            if(recordDeleted > 0){
                dao.getAllDashboardRecords()
//            }else{
//                dao.getAllDashboardRecords()
//            }
        }
    }

}
