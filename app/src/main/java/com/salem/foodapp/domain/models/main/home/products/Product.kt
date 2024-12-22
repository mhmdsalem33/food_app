package com.salem.foodapp.domain.models.main.home.products


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class Product(
    @SerializedName("availabilityStatus")
    val availabilityStatus: String ? = null,
    @SerializedName("brand")
    val brand: String ? = null,
    @SerializedName("category")
    val category: String ? = null,
    @SerializedName("description")
    val description: String ? = null,
    @SerializedName("dimensions")
    val dimensions: Dimensions ?  = null,
    @SerializedName("discountPercentage")
    val discountPercentage: Double ? = null ,
    @SerializedName("id")
    val id: Int ? = null ,
    @SerializedName("images")
    val images: List<String> ? = null,
    @SerializedName("meta")
    val meta: Meta ?= null,
    @SerializedName("minimumOrderQuantity")
    val minimumOrderQuantity: Int ? = null,
    @SerializedName("price")
    val price: Double ? = null,
    @SerializedName("rating")
    val rating: Double ? = null,
    @SerializedName("returnPolicy")
    val returnPolicy: String ? = null,
    @SerializedName("reviews")
    val reviews: List<Review> ? = null,
    @SerializedName("shippingInformation")
    val shippingInformation: String ? = null,
    @SerializedName("sku")
    val sku: String ? = null,
    @SerializedName("stock")
    val stock: Int ? = null,
    @SerializedName("tags")
    val tags: List<String> ? = null,
    @SerializedName("thumbnail")
    val thumbnail: String ? = null,
    @SerializedName("title")
    val title: String ? = null,
    @SerializedName("warrantyInformation")
    val warrantyInformation: String ? = null,
    @SerializedName("weight")
    val weight: Int ? = null
)