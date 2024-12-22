package com.salem.foodapp.domain.usecases.main

import com.salem.foodapp.domain.repo.home.HomeRepository

class GetSearchUseCase( private val homeRepository: HomeRepository) {
    suspend operator fun invoke( searchType : String , query : String)  = homeRepository.getSearch(searchType, query)
}