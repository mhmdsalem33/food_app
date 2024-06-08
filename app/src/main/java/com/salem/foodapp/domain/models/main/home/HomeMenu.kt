package com.salem.foodapp.domain.models.main.home

import androidx.compose.ui.res.stringResource
import com.salem.foodapp.R

enum class HomeMenu(val title: String, val icon: Int) {
    HOME(  "Home" , R.drawable.document),
    MY_PROFILE("My Profile", R.drawable.profile),
    DELIVERY_ADDRESS("Delivery Address", R.drawable.location),
    PAYMENT_METHOD("Payment Methods", R.drawable.wallet),
    CONTACT_US("Contact Us", R.drawable.message),
}