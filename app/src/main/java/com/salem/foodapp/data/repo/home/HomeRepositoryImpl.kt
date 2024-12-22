package com.salem.foodapp.data.repo.home

import android.util.Log
import com.sa.cap.data.core.ResponseState
import com.salem.foodapp.data.data_source.remote.api.ApiService
import com.salem.foodapp.data.extentions.safeApiCallForKtor
import com.salem.foodapp.domain.models.main.home.search.HomeResponse
import com.salem.foodapp.domain.repo.home.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(
    private val apiService: ApiService
) : HomeRepository {
    override suspend fun getSearch(
        searchType: String,
        query: String
    ): Flow<ResponseState<HomeResponse>> = flow {
        try {
            emit(ResponseState.Loading())
            val searchResponse =
                safeApiCallForKtor<HomeResponse> { apiService.search(searchType, query) }
            emit(searchResponse)
        } catch (t: Throwable) {
            Log.e("testApp", t.message ?: "")
        }
    }

    override suspend fun getRecipes(): Flow<ResponseState<HomeResponse>> = flow {
        try {
            emit(ResponseState.Loading())
            val recipeResponse = safeApiCallForKtor<HomeResponse> { apiService.getRecipes() }
            emit(recipeResponse)

        } catch (t: Throwable) {
            Log.e("testApp", t.message ?: "")
        }
    }

    override suspend fun getProducts(): Flow<ResponseState<HomeResponse>> = flow {
        try {
            emit(ResponseState.Loading())
            val productResponse = safeApiCallForKtor<HomeResponse> { apiService.getProducts() }
            emit(productResponse)
        } catch (t: Throwable) {
            Log.e("testApp", t.message ?: "")
        }
    }

}