package com.salem.foodapp.domain.usecases.main

import com.sa.cap.data.core.ResponseState
import com.salem.foodapp.domain.models.main.home.recipes.RecipesResponse
import com.salem.foodapp.domain.repo.home.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetRecipesUseCase ( private val homeRepository: HomeRepository) {
    suspend operator fun invoke() = homeRepository.getRecipes()
}