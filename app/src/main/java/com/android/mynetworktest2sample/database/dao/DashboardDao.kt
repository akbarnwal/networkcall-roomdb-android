package com.android.mynetworktest2sample.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.android.mynetworktest2sample.database.tables.DashboardEntity

@Dao
interface DashboardDao {
    @Insert
    fun insertDashboardRecord(dashboardEntity: DashboardEntity)

    @Update
    fun updateDashboardRecord(dashboardEntity: DashboardEntity)

    @Delete
    fun deleteDashboardRecord(dashboardEntity: DashboardEntity)

    @Query("SELECT * FROM dashboard_table")
    fun getAllDashboardRecords(): List<DashboardEntity>

    @Query("DELETE FROM dashboard_table WHERE uid = :uId")
    fun deleteDashboardRecordById(uId: Long): Int

//    suspend fun deleteProduct(product: Product): Int
}
