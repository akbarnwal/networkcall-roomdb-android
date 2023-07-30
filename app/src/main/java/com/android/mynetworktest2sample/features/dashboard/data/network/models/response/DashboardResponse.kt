package com.android.mynetworktest2sample.features.dashboard.data.network.models.response

import com.google.gson.annotations.SerializedName

data class DashboardResponse(
    @SerializedName("id")
    val id: Int = -1,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("description")
    val description: String  = "",
    @SerializedName("price")
    val price: Int = 0,
    @SerializedName("discountPercentage")
    val discountPercentage: Double  = 0.0,
    @SerializedName("rating")
    val rating: Double = 0.0,
    @SerializedName("stock")
    val stock: Int = 0,
    @SerializedName("brand")
    val brand: String  = "",
    @SerializedName("category")
    val category: String  = "",
    @SerializedName("thumbnail")
    val thumbnail: String = "",
    @SerializedName("images")
    val images: List<String> = emptyList()
){
    companion object{
        val empty = DashboardResponse()
    }
}
