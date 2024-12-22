package com.salem.foodapp.presentation.ui.activity.screens.main.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sa.cap.data.core.ResponseState
import com.salem.foodapp.domain.models.main.home.search.HomeResponse
import com.salem.foodapp.domain.usecases.main.GetProductsUseCase
import com.salem.foodapp.domain.usecases.main.GetRecipesUseCase
import com.salem.foodapp.domain.usecases.main.GetSearchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getRecipesUseCase: GetRecipesUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    private val searchUseCase: GetSearchUseCase
) : ViewModel() {


    var searchQuery = ""
    var searchType: String = "recipes"

    private val _homeStateRecipes = MutableStateFlow<ResponseState<HomeResponse>>(ResponseState.Idle())
    val homeStateRecipes = _homeStateRecipes.asStateFlow()


    private val _homeStateProducts =
        MutableStateFlow<ResponseState<HomeResponse>>(ResponseState.Idle())
    val homeStateProducts = _homeStateProducts.asStateFlow()

    init {
        getRecipes()
        getProducts()
    }


    fun getHome(){
        when(searchType){
            "recipes"  -> getRecipes()
            "products" ->  getProducts()
        }
    }


    private var searchJob: Job? = null

    private fun getRecipes(searchType : String = "recipes") {
        searchJob?.cancel()
        searchJob = viewModelScope.launch(Dispatchers.IO) {
            searchUseCase(searchType, searchQuery).collect {
                _homeStateRecipes.emit(it)
            }
        }
    }


    private var searchProductsJob: Job? = null
    private fun getProducts(searchType: String = "products") {
        searchProductsJob?.cancel()
        searchProductsJob = viewModelScope.launch(Dispatchers.IO) {
            searchUseCase(searchType, searchQuery).collect {
                _homeStateProducts.emit(it)
            }
        }
    }


    init {
//        getRecipes()
//        getProducts()
    }

//    private fun getRecipes() = viewModelScope.launch(Dispatchers.IO) {
//        getRecipesUseCase().collect {
//            _homeState.emit(it)
//        }
//    }
//
//
////    private val _productsState = MutableStateFlow<ResponseState<HomeResponse>>(ResponseState.Idle())
////    val productsState = _productsState.asStateFlow()
//
//    private fun getProducts() = viewModelScope.launch(Dispatchers.IO) {
//        getProductsUseCase().collect {
//            _homeState.emit(it)
//            Log.d("TAG", "getProducts: ${it.data}")
//        }
//    }


    override fun onCleared() {
        super.onCleared()

    }


}