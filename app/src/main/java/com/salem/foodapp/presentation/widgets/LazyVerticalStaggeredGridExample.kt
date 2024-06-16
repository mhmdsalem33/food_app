package com.salem.foodapp.presentation.widgets

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
@Preview()
fun LazyVerticalStaggeredGridExample() {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(2.dp),
        verticalItemSpacing = 10.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {

        val itemCount = 100

        item {
            // First item: Text displaying the number of items
            Text(
                text = "Number of items: $100",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.Gray, RoundedCornerShape(10.dp))
                    .padding(16.dp),
                color = Color.White,
            )
        }

        items(itemCount - 1) { index ->
            // All other items: Box elements
            val randomHeight  = Random.nextInt(100 , 200 )

            val colors = listOf(
                Color.Red,
                Color.Blue,
                Color.Magenta,
                Color.Yellow,
                Color.Cyan,
            )

            val context = LocalContext.current

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(colors.random())
                    .clickable {
                        Toast
                            .makeText( context, index.toString(), Toast.LENGTH_SHORT)
                            .show()
                    },
            )
        }

    }

}