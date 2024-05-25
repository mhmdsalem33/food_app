package com.salem.foodapp.presentation.widgets.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salem.foodapp.R
import com.salem.foodapp.presentation.theme.AbeeZeeRegular
import com.salem.foodapp.presentation.theme.gilroySemiBold
import com.salem.foodapp.presentation.theme.omnesArabicMedium
import com.salem.foodapp.presentation.theme.poppinsMedium
import com.salem.foodapp.presentation.theme.poppinsSemiBold
import com.salem.foodapp.presentation.theme.sofiaProLight


@Composable
@Preview(showBackground = true , showSystemUi = true)
fun  OrangeRoundButton(
    onButtonClick : () -> Unit = {}
){
    Button(
        onClick = { onButtonClick() },
        modifier = Modifier.fillMaxWidth().height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.orange)
        ),
    ) {
        Text(
            text = stringResource(id = R.string.login).uppercase(),
            fontFamily = omnesArabicMedium(),
        )
    }
}