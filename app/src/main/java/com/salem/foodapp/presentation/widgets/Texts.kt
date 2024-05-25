package com.salem.foodapp.presentation.widgets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.salem.foodapp.R
import com.salem.foodapp.presentation.theme.sofiaProLight

@Composable
fun TextSofiaPro(
    text : String = stringResource(id = R.string.email)
){
    Text(
        text = text ,
        fontFamily = sofiaProLight(),
        color = colorResource(id = R.color.gray_4),
        fontWeight = FontWeight.Bold
    )

}