package com.salem.foodapp.presentation.widgets.buttons

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.salem.foodapp.R

@Preview
@Composable
fun OrangeCircleButton(
    onButtonClick: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = {
            onButtonClick()
        },
        containerColor = colorResource(id = R.color.orange),
        modifier = Modifier.clip(CircleShape)
    ) {
        Icon(
            Icons.Outlined.KeyboardArrowRight,
            tint = Color.White,
            contentDescription = ""
        )
    }
}
