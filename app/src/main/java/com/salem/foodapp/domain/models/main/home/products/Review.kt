package com.salem.foodapp.domain.models.main.home.products


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class Review(
    @SerializedName("comment")
    val comment: String ? =null,
    @SerializedName("date")
    val date: String ? =null,
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("reviewerEmail")
    val reviewerEmail: String ? =null,
    @SerializedName("reviewerName")
    val reviewerName: String ? =null
)