package com.salem.foodapp.presentation.widgets.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salem.foodapp.R
import com.salem.foodapp.presentation.extentions.generateRandomPrice
import com.salem.foodapp.presentation.ui.theme.ttComponentFont

@Preview
@Composable
fun Price(
    price: String? = null,
    marginStart: Int = 0,
    marginTop: Int = 0,
    marginEnd : Int = 0
) {

    Text(
        modifier = Modifier
            .padding(start = marginStart.dp, top = marginTop.dp , end = marginEnd.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = Color.White, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp, vertical = 5.dp),
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = colorResource(id = R.color.orange),
                    fontSize = 9.sp,
                )
            ) {
                append("$")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontFamily = ttComponentFont(),
                    fontSize = 16.sp
                )
            ) {
                append(price ?: generateRandomPrice().toString())
            }
        },
    )


}
