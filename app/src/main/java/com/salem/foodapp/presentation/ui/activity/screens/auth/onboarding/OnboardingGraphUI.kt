package com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salem.foodapp.R
import com.salem.foodapp.presentation.ui.theme.OmnesArabic
import com.salem.foodapp.presentation.ui.theme.gilroySemiBold
import com.salem.foodapp.presentation.widgets.spaces.SpaceHeight25
import com.salem.foodapp.presentation.widgets.spaces.SpaceHeight8

@Composable
fun OnboardingGraphUI(onboardingModel: OnboardingModel , size: Int = 0 , index: Int = 0 ) {


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = onboardingModel.image),
                contentDescription = "Image",
                modifier = Modifier
                    .height(400.dp).fillMaxWidth()
                    .padding(top = 50.dp, start = 10.dp, end = 10.dp),
                alignment = Alignment.BottomCenter,
            )

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                IndicatorUI(size , index)
            }

            SpaceHeight25()

            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = onboardingModel.title),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    letterSpacing = 1.sp,
                    fontFamily = gilroySemiBold()
                )

                SpaceHeight8()

                Text(
                    text = stringResource(id = onboardingModel.description),
                    style = MaterialTheme.typography.bodyLarge,
                    color = colorResource(id = R.color.gray_3),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp),
                    letterSpacing = 1.sp,
                    fontFamily = OmnesArabic()
                )
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview1() {
    OnboardingGraphUI(OnboardingModel.FirstPage , 3 , 0)
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview2() {
    OnboardingGraphUI(OnboardingModel.SecondPage  , 3 , 1 )
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview3() {
    OnboardingGraphUI(OnboardingModel.ThirdPages , 3 , 2 )
}