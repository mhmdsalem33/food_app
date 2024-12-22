package com.salem.foodapp.domain.models.main.home.recipes


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
@Keep
data class RecipesResponse(
    @SerializedName("limit")
    val limit: Int = 0,
    @SerializedName("recipes")
    val recipes: List<Recipe> = emptyList(),
    @SerializedName("skip")
    val skip: Int = 0,
    @SerializedName("total")
    val total: Int = 0
)