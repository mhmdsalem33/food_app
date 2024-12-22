package com.salem.foodapp.presentation.ui.activity.screens.main.home_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.salem.foodapp.R
import com.salem.foodapp.presentation.ui.theme.sofiaProLight
import com.salem.foodapp.presentation.widgets.text_fields.SearchTextField
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.pager.*
import com.salem.foodapp.presentation.ui.theme.ChangeStatusBarColorAndNavigationBar

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController? = null,
    homeViewModel: HomeViewModel = koinViewModel()
) {
//
    ChangeStatusBarColorAndNavigationBar(
        isStatusBarIconColorDark = true,
        isNavigationBarIconColorDark = true,
        isContentTopTransparent = true,
    )

    val pagerState = rememberPagerState(initialPage = 0)

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(colorResource(id = R.color.gray_9))
    ) {

        val interactionSource = remember { MutableInteractionSource() }
        var search by remember { mutableStateOf("") }


        SearchTextField(
            value = search,
            onValueChange = {
                search = it
                homeViewModel.searchQuery = it
                homeViewModel.getHome()
                Log.e("testSearch", search)

            },
            placeholderText = stringResource(id = R.string.find_fav_fod),
            keyboardType = KeyboardType.Email,
            marginHorizontal = 15,
            trailingIcon = {
                if (search.isNotEmpty()) {
                    Image(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "clear icon",
                        modifier = Modifier.clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            search = ""
                            homeViewModel.searchQuery = ""
                            homeViewModel.getHome()
                        },
                        colorFilter = ColorFilter.tint(color = colorResource(id = R.color.gray_4))
                    )
                }
            },
            leadingIcon = {
                Image(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "clear icon",
                    colorFilter = ColorFilter.tint(color = colorResource(id = R.color.gray_4))
                )
            }
        )


        TabLayout(pagerState)
        ViewPagerWithScreens(pagerState)


    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(pagerState: PagerState) {
    var selectedTab by remember { mutableIntStateOf(0) } // 0 = Food Item, 1 = Products

    val tabs = listOf("Food Item", "Products")
    val interactionSource = remember { MutableInteractionSource() }


    LaunchedEffect(pagerState.currentPage) {
        selectedTab = pagerState.currentPage
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, RoundedCornerShape(50.dp))
            .border(1.dp, Color(0xFFF2EAEA), RoundedCornerShape(50.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEachIndexed { index, title ->
            val isSelected = selectedTab == index
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .background(
                        if (isSelected) Color(0xFFFF6E40) else Color.White,
                        shape = RoundedCornerShape(50.dp)
                    )
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        selectedTab = index
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    color = if (isSelected) Color.White else Color(0xFFFF6E40),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 12.dp),
                    fontFamily = sofiaProLight()
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    when (selectedTab) {
        0 -> {
            LaunchedEffect(selectedTab) {
                pagerState.animateScrollToPage(selectedTab)
            }
        }
        1 -> {
            LaunchedEffect(selectedTab) {
                pagerState.animateScrollToPage(selectedTab)
            }
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPagerWithScreens(pagerState: PagerState) {

    LaunchedEffect(pagerState.currentPage) {
        Log.e("testPage", pagerState.currentPage.toString())
    }

    HorizontalPager(
        count = 2,
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        when (page) {
            0 -> FoodItemList()
            1 -> ProductsList()
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun TabLayoutPreview() {
    val pagerState = rememberPagerState(initialPage = 0)
    TabLayout(pagerState = pagerState)
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewHomeScreen() {
    HomeScreen()
}