package com.salem.foodapp.data.data_source.remote.api


import com.salem.foodapp.domain.models.main.home.recipes.RecipesResponse
import retrofit2.Response
import retrofit2.http.GET
interface AuthServices {

    @GET("recipes")
    suspend fun getRecipes(): Response<RecipesResponse>


}