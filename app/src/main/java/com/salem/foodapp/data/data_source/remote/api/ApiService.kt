package com.salem.foodapp.data.data_source.remote.api

import com.salem.foodapp.presentation.common.Constants.baseUrl
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class ApiService (private val client: HttpClient){

    private val recipesEndPoint   = "recipes"
    private val productsEndPoint  = "products"
    suspend fun getRecipes(): HttpResponse {
        val response = client.get("${baseUrl}$recipesEndPoint")
        return response.body()
    }


    suspend fun getProducts(): HttpResponse {
        val response = client.get("${baseUrl}$productsEndPoint")
        return response.body()
    }


    suspend fun search(searchType : String , query: String):HttpResponse{
        val response = client.get("$baseUrl$searchType/search"){
            url {
                parameters.append("q" , query )
            }
        }
        return response.body()
    }

}