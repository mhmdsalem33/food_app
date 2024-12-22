package com.salem.foodapp.presentation.ui.activity.screens.main.main_preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.salem.foodapp.presentation.component.MenuComponent
import com.salem.foodapp.presentation.component.SlidingMenu
import com.salem.foodapp.presentation.ui.activity.screens.main.home_screen.HomeScreen

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewHomeComponent() {
    SlidingMenu()
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewHomeScreen() {
    HomeScreen()
}
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewMenuComponent() {
    MenuComponent()
}


