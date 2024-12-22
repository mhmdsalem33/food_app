package com.salem.foodapp.presentation.ui.activity.screens.main.home_screen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sa.cap.data.core.ResponseState
import com.salem.foodapp.presentation.widgets.EmptyCart
import com.salem.foodapp.presentation.widgets.Erros.ShowError
import com.salem.foodapp.presentation.widgets.indicators.BallSpinFadeLoaderIndicators
import com.salem.foodapp.presentation.widgets.items.ProductsItems
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductsList(
    homeViewModel: HomeViewModel = koinViewModel()
) {

//
   LaunchedEffect(key1 = Unit) {
       homeViewModel.searchType = "products"
//       homeViewModel.search()
   }

    val productsState by homeViewModel.homeStateProducts.collectAsStateWithLifecycle()

    when (productsState) {
        is ResponseState.Loading -> {
            Log.e("testLoading", "LOADING")
            BallSpinFadeLoaderIndicators()
        }

        is ResponseState.Success -> {
            val productList = productsState.data?.products ?: emptyList()
            if (productList.isNotEmpty()){
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(productList.size) { index ->
                        val product = productList[index]
                        ProductsItems(product)
                    }
                }
            }else{
                EmptyCart()
            }

        }

        is ResponseState.Error -> {
            ShowError(productsState.message ?: "")
        }

        else -> Unit
    }

}
