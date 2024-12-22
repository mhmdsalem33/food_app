package com.salem.foodapp.domain.models.main.home.search

import com.google.gson.annotations.SerializedName
import com.salem.foodapp.domain.models.main.home.products.Product
import com.salem.foodapp.domain.models.main.home.recipes.Recipe
import kotlinx.serialization.Serializable

@Serializable
data class HomeResponse(
    @SerializedName("products")
    val products: List<Product> ? = null,
    @SerializedName("recipes")
    val recipes: List<Recipe> ? = null,
    @SerializedName("limit")
    val limit: Int ? = null,
    @SerializedName("skip")
    val skip: Int ? = null,
    @SerializedName("total")
    val total: Int ? = null
)
