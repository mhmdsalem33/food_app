package com.salem.foodapp.presentation.widgets.indicators

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.salem.foodapp.R

@Composable
fun Indicators(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        repeat(size) {
            key(it) {
                Indicator(isSelected = it == index)
            }
        }
    }
}


@Composable
fun Indicator(
    isSelected: Boolean,
    isSelectedIndicatorSize : Dp = 45.dp,
    unSelectedIndicatorSize : Dp = 10.dp,
    isSelectedIndicatorColor : Color =  colorResource(id = R.color.yellow),
    unSelectedIndicatorColor : Color  =  colorResource(id = R.color.yellow_transparent_40),

    ) {
    val width = animateDpAsState(
        targetValue = if (isSelected) isSelectedIndicatorSize else unSelectedIndicatorSize ,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = ""
    )
    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                color = if (isSelected) isSelectedIndicatorColor else unSelectedIndicatorColor
            )
    )
}
