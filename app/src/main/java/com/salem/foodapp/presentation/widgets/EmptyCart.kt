package com.salem.foodapp.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.salem.foodapp.R
import com.salem.foodapp.presentation.ui.theme.gilroySemiBold
import com.salem.foodapp.presentation.widgets.spaces.SpaceHeight10


@Composable
fun EmptyCart(){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.shopping), contentDescription = "")
        SpaceHeight10()
        Text(
            text = "There is no results found",
            fontFamily = gilroySemiBold()
        )

    }
}