package com.salem.foodapp.domain.models.main.home.products


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
@Keep
data class ProductsResponse(
    @SerializedName("limit")
    val limit: Int ? = null,
    @SerializedName("products")
    val products: List<Product> ? = null,
    @SerializedName("skip")
    val skip: Int ? = null,
    @SerializedName("total")
    val total: Int ? = null
)