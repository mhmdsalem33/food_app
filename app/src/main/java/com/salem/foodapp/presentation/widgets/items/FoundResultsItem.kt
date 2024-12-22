package com.salem.foodapp.presentation.widgets.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salem.foodapp.R
import com.salem.foodapp.domain.models.main.home.recipes.Recipe
import com.salem.foodapp.presentation.ui.theme.gilroySemiBold
import com.salem.foodapp.presentation.ui.theme.omnesArabicSemiBold
import com.salem.foodapp.presentation.ui.theme.sofiaProLight
import com.salem.foodapp.presentation.widgets.image.RoundImage
import com.salem.foodapp.presentation.widgets.rating.RatingSection


@Composable
fun FoundResultsItem(recipeList: List<Recipe>) {

    val gridState = rememberLazyStaggeredGridState()

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(2.dp, bottom = 15.dp),
        verticalItemSpacing = 15.dp,
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        state = gridState,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)

    ) {

        val itemCount = recipeList.size

        // FIRST INDEX
        item {
            Column {
                Text(text = "Found", fontFamily = gilroySemiBold())
                Text(text = "$itemCount results", fontFamily = gilroySemiBold())
            }
        }

        items(recipeList) { recipe ->
            PizzaItemCard(
                imageUrl = recipe.image,
                price = null,
                rating = "${recipe.rating}",
                reviewCount = "${recipe.reviewCount}",
                description = recipe.ingredients.firstOrNull() ?: "",
                title = recipe.name,
                isFavorite = false,
                onFavoriteClick = {}
            )
        }
    }

}


@Composable
fun PizzaItemCard(
    imageUrl: String,
    price: String?,
    rating: String,
    reviewCount: String,
    title: String,
    description: String,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(245.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
    ) {

        Column(
            Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                RoundImage(url = imageUrl, 170)

                //PRICE
                Price(
                    price = price,
                    marginStart = 5,
                    marginTop = 8
                )

                // Fav Icon
                Image(
                    modifier = Modifier
                        .padding(top = 8.dp, end = 5.dp)
                        .align(Alignment.TopEnd)
                        .clickable {
                            onFavoriteClick()
                        },
                    painter = painterResource(id = R.drawable.ic_fav),
                    contentDescription = ""
                )
            }

            //RATING
            RatingSection(
                rating = rating,
                reviewCount = reviewCount,
                offsetValue = -15,
                marginStart = 5
            )

            // NAME
            Box(
                modifier =
                Modifier
                    .offset(y = (-8).dp)
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontFamily = omnesArabicSemiBold(),
                    maxLines = 1,
                )
            }

            // Description
            Box(
                modifier = Modifier
                    .offset(y = (-10).dp)
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontFamily = sofiaProLight(),
                    maxLines = 1,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewFoundResultsItem() {
    // Mock data
    val mockRecipeList = listOf(
        Recipe(
            name = "Pepperoni Pizza",
            image = "https://example.com/image1.jpg",
            rating = 4.5,
            reviewCount = 100,
            ingredients = listOf("Cheese", "Tomato Sauce", "Pepperoni")
        ),
        Recipe(
            name = "Veggie Pizza",
            image = "https://example.com/image2.jpg",
            rating = 4.0,
            reviewCount = 85,
            ingredients = listOf("Cheese", "Tomato Sauce", "Veggies")
        ),
        Recipe(
            name = "Pepperoni Pizza",
            image = "https://example.com/image1.jpg",
            rating = 4.5,
            reviewCount = 100,
            ingredients = listOf("Cheese", "Tomato Sauce", "Pepperoni")
        ),
        Recipe(
            name = "Veggie Pizza",
            image = "https://example.com/image2.jpg",
            rating = 4.0,
            reviewCount = 85,
            ingredients = listOf("Cheese", "Tomato Sauce", "Veggies")
        ),
        Recipe(
            name = "Pepperoni Pizza",
            image = "https://example.com/image1.jpg",
            rating = 4.5,
            reviewCount = 100,
            ingredients = listOf("Cheese", "Tomato Sauce", "Pepperoni")
        ),
        Recipe(
            name = "Veggie Pizza",
            image = "https://example.com/image2.jpg",
            rating = 4.0,
            reviewCount = 85,
            ingredients = listOf("Cheese", "Tomato Sauce", "Veggies")
        )
    )
    FoundResultsItem(recipeList = mockRecipeList)
}

@Preview(showBackground = true)
@Composable
fun PizzaItemCardPreview() {
    // Mock data
    PizzaItemCard(
        imageUrl = "https://cdn.dummyjson.com/recipe-images/1.webp",
        price = "12.99",
        rating = "4.5",
        reviewCount = "100",
        description = "This is a delicious pizza with a variety of toppings.",
        title = "Pizza",
        isFavorite = false,
        onFavoriteClick = {}
    )
}


