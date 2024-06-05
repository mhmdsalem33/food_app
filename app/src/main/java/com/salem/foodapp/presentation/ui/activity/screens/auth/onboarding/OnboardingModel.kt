package com.salem.foodapp.presentation.ui.activity.screens.auth.onboarding

import androidx.annotation.DrawableRes
import com.salem.foodapp.R

sealed class OnboardingModel(
    @DrawableRes val image: Int,
    val title: Int,
    val description: Int,
) {

    data object FirstPage : OnboardingModel(
        image = R.drawable.img_slider_one,
        title = R.string.browse_menu,
        description = R.string.our_app_can_send_u_everywhere
    )

    data object SecondPage : OnboardingModel(
        image = R.drawable.img_slider_two,
        title = R.string.even_to_space,
        description = R.string.our_app_can_send_u_everywhere
    )

    data object ThirdPages : OnboardingModel(
        image = R.drawable.img_slider_three,
        title = R.string.pick_up_delivery,
        description = R.string.our_app_can_send_u_everywhere
    )

}


