package com.salem.foodapp.presentation.widgets.indicators

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.salem.foodapp.R
import com.spr.jetpack_loading.components.indicators.BallSpinFadeLoaderIndicator

@Composable
fun BallSpinFadeLoaderIndicators() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BallSpinFadeLoaderIndicator(
            color = colorResource(id = R.color.orange),
            ballRadius = 10f,
            radius = 50f
        )
    }
}