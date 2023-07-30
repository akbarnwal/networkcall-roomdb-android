package com.android.mynetworktest2sample.database.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dashboard_table")
data class DashboardEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Long = 0,

    @ColumnInfo(name = "id") val id: Int? = 0,
    @ColumnInfo(name = "title") val title: String? = "",
    @ColumnInfo(name = "description") val desc: String? = "",
    @ColumnInfo(name = "price") val price: Int? = 0
){
    companion object{
        val empty = DashboardEntity()
    }

}