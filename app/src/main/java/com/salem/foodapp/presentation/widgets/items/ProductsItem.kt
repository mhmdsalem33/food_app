package com.salem.foodapp.presentation.widgets.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salem.foodapp.domain.models.main.home.products.Dimensions
import com.salem.foodapp.domain.models.main.home.products.Product
import com.salem.foodapp.domain.models.main.home.products.Review
import com.salem.foodapp.presentation.ui.theme.omnesArabicSemiBold
import com.salem.foodapp.presentation.ui.theme.sofiaProLight
import com.salem.foodapp.presentation.widgets.image.RoundImage
import com.salem.foodapp.presentation.widgets.rating.RatingSection


@Composable
fun ProductsItems(product: Product) {

    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp , vertical = 5.dp)
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(12.dp))
    ) {

        Box(modifier = Modifier.fillMaxWidth()) {

            // Image
            RoundImage(
                url = product.thumbnail ?: "",
                150
            )
            // RATING
            RatingSection(
                rating = product.rating.toString(),
                reviewCount = product.reviews?.size.toString(),
                marginStart = 6,
                marginTop = 8
            )

            Box(modifier = Modifier.align(Alignment.TopEnd)) {

                // PRICE
                Price(
                    price = product.price.toString(),
                    marginTop = 8,
                    marginEnd = 6
                )
            }
        }

        //Name
        Text(
            text = product.title ?: "",
            fontSize = 15.sp,
            color = Color.Black,
            fontFamily = omnesArabicSemiBold(),
            maxLines = 1,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
        )

        // Description
        Text(
            text = product.description ?: "",
            fontSize = 14.sp,
            color = Color.Gray,
            fontFamily = sofiaProLight(),
            maxLines = 3,
            modifier = Modifier.padding(start = 10.dp, bottom = 10.dp),
            lineHeight = 16.sp
        )
    }
}


@Composable
@Preview
fun ProductsItemsD(
    product: Product = Product(
        id = 1,
        title = "Sample Product",
        description = "This is a sample product description showcasing the product item UI.",
        price = 29.99,
        thumbnail = "https://via.placeholder.com/150",
        rating = 4.7,
        availabilityStatus = "In Stock",
        brand = "SampleBrand",
        category = "Electronics",
        discountPercentage = 10.0,
        images = listOf("https://via.placeholder.com/200"),
        minimumOrderQuantity = 1,
        returnPolicy = "30-day return policy",
        shippingInformation = "Free shipping within 5 days",
        sku = "SKU12345",
        stock = 100,
        tags = listOf("Gadget", "Tech"),
        warrantyInformation = "1-year warranty"
    )
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(12.dp))
    ) {

        Box(modifier = Modifier.fillMaxWidth()) {

            // Image
            RoundImage(
                url = product.images?.firstOrNull() ?: "",
                150
            )

            // RATING
            RatingSection(
                rating = "4.5",
                reviewCount = "100",
                marginStart = 6,
                marginTop = 8
            )

            Box(modifier = Modifier.align(Alignment.TopEnd)) {

                // PRICE
                Price(
                    price = product.price.toString(),
                    marginTop = 8,
                    marginEnd = 6
                )
            }
        }

        // Name
        Text(
            text = product.title ?: "",
            fontSize = 15.sp,
            color = Color.Black,
            fontFamily = omnesArabicSemiBold(),
            maxLines = 1,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
        )

        // Description
        Text(
            text = product.description ?: "",
            fontSize = 14.sp,
            color = Color.Gray,
            fontFamily = sofiaProLight(),
            maxLines = 3,
            modifier = Modifier.padding(start = 10.dp, bottom = 10.dp),
            lineHeight = 16.sp
        )
    }
}
