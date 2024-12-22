package com.salem.foodapp.domain.usecases.main

import com.salem.foodapp.domain.repo.home.HomeRepository

class GetProductsUseCase ( private val homeRepository: HomeRepository ) {
    suspend operator fun invoke() =  homeRepository.getProducts()
}