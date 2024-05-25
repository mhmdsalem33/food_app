package com.salem.foodapp.presentation.widgets.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.salem.foodapp.R

@Composable
@Preview(showBackground = true , showSystemUi = true)
fun ArrowBack(
    onButtonClick: () -> Unit = {},
    roundSize : Dp = 4.dp,
    backgroundColor : Color = colorResource(id = R.color.white)
) {
    FloatingActionButton(
        onClick = {
            onButtonClick()
        },
        containerColor = backgroundColor ,
        modifier = Modifier.size(40.dp).clip(RoundedCornerShape(roundSize)),
        elevation =  FloatingActionButtonDefaults.elevation(
            defaultElevation = 0.1.dp,

        )
    ) {
        Icon(
            Icons.Outlined.KeyboardArrowLeft,
            tint = Color.Black,
            contentDescription = ""
        )
    }
}
