package com.salem.foodapp.domain.models.main.home.products


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class Dimensions(
    @SerializedName("depth")
    val depth: Double ? = null,
    @SerializedName("height")
    val height: Double ? = null,
    @SerializedName("width")
    val width: Double ? = null
)