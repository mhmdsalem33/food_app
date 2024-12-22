package com.salem.foodapp.domain.models.main.home.recipes


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class Recipe(
    @SerializedName("caloriesPerServing")
    val caloriesPerServing: Int = 0,
    @SerializedName("cookTimeMinutes")
    val cookTimeMinutes: Int = 0,
    @SerializedName("cuisine")
    val cuisine: String = "",
    @SerializedName("difficulty")
    val difficulty: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image")
    val image: String = "",
    @SerializedName("ingredients")
    val ingredients: List<String> = emptyList(),
    @SerializedName("instructions")
    val instructions: List<String> = emptyList(),
    @SerializedName("mealType")
    val mealType: List<String> = emptyList(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("prepTimeMinutes")
    val prepTimeMinutes: Int = 0,
    @SerializedName("rating")
    val rating: Double = 0.0,
    @SerializedName("reviewCount")
    val reviewCount: Int = 0,
    @SerializedName("servings")
    val servings: Int = 0,
    @SerializedName("tags")
    val tags: List<String> = emptyList(),
    @SerializedName("userId")
    val userId: Int = 0
)