package com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.dropUnlessResumed
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.salem.foodapp.R
import com.salem.foodapp.data.data_source.local.static_data.onBoardingData
import com.salem.foodapp.domain.models.auth.onborading.OnBoardingModel
import com.salem.foodapp.presentation.theme.ChangeStatusBarColorAndNavigationBar
import com.salem.foodapp.presentation.theme.OmnesArabic
import com.salem.foodapp.presentation.theme.gilroySemiBold
import com.salem.foodapp.presentation.widgets.buttons.OrangeCircleButton
import com.salem.foodapp.presentation.widgets.indicators.Indicators
import com.salem.foodapp.presentation.widgets.spaces.SpaceHeight25
import com.salem.foodapp.presentation.widgets.spaces.SpaceHeight60
import com.salem.foodapp.presentation.widgets.spaces.SpaceHeight8
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen() {
    ChangeStatusBarColorAndNavigationBar(
        isStatusBarIconColorDark = true,
        isNavigationBarIconColorDark = true,
        isContentTopTransparent = false,
        navigationBarBackgroundColor = colorResource(id = R.color.white).toArgb()
    )

    val pageState = rememberPagerState()
    val scope     = rememberCoroutineScope()

    HorizontalPager(
        count = onBoardingData.size ,
        state = pageState ,
    ) { currentPageIndex ->
        onBoardingData.forEachIndexed{ index , onBoardingItem ->
            if (currentPageIndex == index ){
                OnBoardingContent(
                    item =  onBoardingItem ,
                    indicatorCurrentIndex = index,
                    pageState = pageState,
                    scope =  scope
                )
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingContent(
    item: OnBoardingModel = OnBoardingModel(),
    indicatorCurrentIndex: Int = 0,
    pageState: PagerState ,
    scope: CoroutineScope ,
) {
    val scroll = rememberScrollState()
    val indicatorSize = onBoardingData.size

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(scroll)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Image",
                modifier = Modifier
                    .height(450.dp)
                    .padding(top = 50.dp, start = 10.dp, end = 10.dp),
                alignment = Alignment.BottomCenter
            )

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Indicators( indicatorSize , indicatorCurrentIndex)
            }

            SpaceHeight25()

            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text          = stringResource(id = item.title),
                    style         = MaterialTheme.typography.headlineMedium,
                    color         = MaterialTheme.colorScheme.onBackground,
                    fontWeight    = FontWeight.Bold,
                    textAlign     = TextAlign.Center,
                    letterSpacing = 1.sp,
                    fontFamily    = gilroySemiBold()
                )

                SpaceHeight8()

                Text(
                    text = stringResource(id = item.desc),
                    style = MaterialTheme.typography.bodyLarge,
                    color = colorResource(id = R.color.gray_3),
                    fontWeight = FontWeight.Bold,
                    textAlign  = TextAlign.Center,
                    modifier   = Modifier.padding(10.dp),
                    letterSpacing = 1.sp,
                    fontFamily = OmnesArabic()
                )

                SpaceHeight8()

                OrangeCircleButton(
                    onButtonClick = dropUnlessResumed {
                        if (indicatorCurrentIndex + 1 < indicatorSize) scope.launch {
                            pageState.animateScrollToPage(pageState.currentPage + 1)
                        }
                    }
                )
                SpaceHeight60()
            }
        }
    }
}


