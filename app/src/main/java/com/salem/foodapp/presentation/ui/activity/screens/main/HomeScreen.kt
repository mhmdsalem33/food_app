package com.salem.foodapp.presentation.ui.activity.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.salem.foodapp.R
import com.salem.foodapp.presentation.widgets.LazyVerticalStaggeredGridExample

@Composable
fun HomeScreen(
    navController: NavHostController? = null) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        Column (
            modifier =
            Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.gray_9))

        ){
            LazyVerticalStaggeredGridExample()
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewHomeScreen() {
    HomeScreen()
}