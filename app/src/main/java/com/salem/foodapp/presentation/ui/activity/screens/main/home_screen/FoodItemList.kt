package com.salem.foodapp.presentation.ui.activity.screens.main.home_screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sa.cap.data.core.ResponseState
import com.salem.foodapp.presentation.widgets.EmptyCart
import com.salem.foodapp.presentation.widgets.Erros.ShowError
import com.salem.foodapp.presentation.widgets.indicators.BallSpinFadeLoaderIndicators
import com.salem.foodapp.presentation.widgets.items.FoundResultsItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun FoodItemList(
    homeViewModel: HomeViewModel = koinViewModel(),
) {

    LaunchedEffect(Unit) {
        homeViewModel.searchType = "recipes"
//        homeViewModel.search()
    }

    val recipesState by homeViewModel.homeStateRecipes.collectAsStateWithLifecycle()

    when (recipesState) {
        is ResponseState.Loading -> {
            BallSpinFadeLoaderIndicators()
        }

        is ResponseState.Success -> {
            val recipeList = recipesState.data?.recipes
            if (!recipeList.isNullOrEmpty()) {
                FoundResultsItem(recipeList)
                Log.e("testData", recipeList.toString())
            }else{
                EmptyCart()
            }
        }

        is ResponseState.Error -> {
            ShowError(recipesState.message ?: "")
        }

        else -> Unit
    }
}

