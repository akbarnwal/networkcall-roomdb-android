package com.android.mynetworktest2sample.features.dashboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.mynetworktest2sample.database.tables.DashboardEntity
import com.android.mynetworktest2sample.features.dashboard.data.network.models.response.DashboardResponse
import com.android.mynetworktest2sample.features.dashboard.data.usecases.DashboardUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val usecase: DashboardUseCaseImpl) :ViewModel() {

    private val _dashboardData = MutableLiveData<List<DashboardEntity>>()
    val dashboardData:LiveData<List<DashboardEntity>> get() = _dashboardData

    private val _deleteRecordStatus = MutableLiveData<Boolean>()
    val deleteRecordStatus: MutableLiveData<Boolean> get() = _deleteRecordStatus

    suspend fun fetchData(){
        val response = usecase.fetchDashboardData()

        _dashboardData.postValue(response)
    }

    suspend fun deleteRecord(uId: Long) {
        val list = usecase.deleteRecord(uId)
//        _deleteRecordStatus.postValue(status)
        _dashboardData.postValue(list)
    }

}
