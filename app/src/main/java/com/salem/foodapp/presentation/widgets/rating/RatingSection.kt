package com.salem.foodapp.presentation.widgets.rating

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.salem.foodapp.presentation.ui.theme.AbeeZeeRegular
import com.salem.foodapp.presentation.ui.theme.ttComponentFont

@Composable
fun RatingSection(
    rating: String,
    reviewCount: String,
    offsetValue : Int  = 0,
    marginStart : Int ,
    marginTop: Int = 0


) {
    Box(
        modifier = Modifier
            .padding(start = marginStart.dp, marginTop.dp)
            .offset(y = (offsetValue).dp)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(12.dp),
                clip = false
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 12.dp, vertical = 6.dp) // Padding inside the box
        ,
//        contentAlignment = Alignment.BottomStart

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            // Rating Value
            Text(
                text = rating,
                fontSize = 14.sp,
                fontFamily = ttComponentFont(),
                color = Color.Black
            )

            Spacer(modifier = Modifier.width(6.dp)) // Space between rating and star

            // Star Icon
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star Icon",
                tint = Color(0xFFFFA500), // Orange color for the star
                modifier = Modifier.size(16.dp)
            )

            Spacer(modifier = Modifier.width(6.dp)) // Space between star and review count

            // Review Count
            Text(
                text = "($reviewCount+)",
                fontSize = 12.sp,
                color = Color.Gray,
                fontFamily = AbeeZeeRegular()
            )
        }
    }
}
