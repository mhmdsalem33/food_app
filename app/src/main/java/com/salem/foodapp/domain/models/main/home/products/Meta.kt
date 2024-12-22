package com.salem.foodapp.domain.models.main.home.products


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class Meta(
    @SerializedName("barcode")
    val barcode: String ? = null,
    @SerializedName("createdAt")
    val createdAt: String ?= null,
    @SerializedName("qrCode")
    val qrCode: String ?= null,
    @SerializedName("updatedAt")
    val updatedAt: String ?= null
)