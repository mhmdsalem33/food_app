package com.salem.foodapp.domain.repo.home

import com.sa.cap.data.core.ResponseState
import com.salem.foodapp.domain.models.main.home.search.HomeResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getSearch(searchType : String , query : String ): Flow<ResponseState<HomeResponse>>
    suspend fun getRecipes():  Flow<ResponseState<HomeResponse>>
    suspend fun getProducts() :Flow<ResponseState<HomeResponse>>

}