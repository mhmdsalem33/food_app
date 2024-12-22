package com.salem.foodapp.presentation.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salem.foodapp.R
import com.salem.foodapp.domain.models.main.home.HomeMenu
import com.salem.foodapp.domain.models.main.home.HomeMenuAction
import com.salem.foodapp.domain.models.main.home.MenuState
import com.salem.foodapp.presentation.ui.activity.screens.main.home_screen.HomeScreen
import com.salem.foodapp.presentation.ui.activity.screens.main.profile.ProfileScreen
import com.salem.foodapp.presentation.ui.theme.gilroySemiBold
import com.salem.foodapp.presentation.widgets.spaces.SpaceHeight25
import com.salem.foodapp.presentation.widgets.spaces.SpaceHeight8
import kotlin.math.roundToInt

@Composable
fun SlidingMenu() {
    var screen by remember { mutableStateOf(HomeMenu.HOME.name) }
    var currentState by remember { mutableStateOf(MenuState.COLLAPSED) }

    val interactionSource = remember { MutableInteractionSource() }

    val updateAnim = updateTransition(currentState, label = "MenuState")
    val scale = updateAnim.animateFloat(
        transitionSpec = {
            when {
                MenuState.EXPANDED isTransitioningTo MenuState.COLLAPSED -> {
                    tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                }

                MenuState.COLLAPSED isTransitioningTo MenuState.EXPANDED -> {
                    tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                }

                else -> {
                    snap()
                }
            }
        }, label = ""
    ) {
        when (it) {
            MenuState.EXPANDED -> 0.7f
            MenuState.COLLAPSED -> 1f
        }
    }
    val transitionOffset = updateAnim.animateOffset({
        when {
            MenuState.EXPANDED isTransitioningTo MenuState.COLLAPSED -> {
                tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            }

            MenuState.COLLAPSED isTransitioningTo MenuState.EXPANDED -> {
                tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            }

            else -> {
                snap()
            }
        }
    }, label = "") {
        when (it) {
            MenuState.EXPANDED -> Offset(750f, 60f)
            MenuState.COLLAPSED -> Offset(0f, 0f)
        }
    }

    val alphaMenu = updateAnim.animateFloat({
        when {
            MenuState.EXPANDED isTransitioningTo MenuState.COLLAPSED -> {
                tween(durationMillis = 300)
            }

            MenuState.COLLAPSED isTransitioningTo MenuState.EXPANDED -> {
                tween(durationMillis = 300)
            }

            else -> {
                snap()
            }
        }
    }, label = "") {
        when (it) {
            MenuState.EXPANDED -> 1f
            MenuState.COLLAPSED -> 0.5f
        }
    }

    val roundness = updateAnim.animateDp({
        when {
            MenuState.EXPANDED isTransitioningTo MenuState.COLLAPSED -> {
                tween(durationMillis = 300)
            }

            MenuState.COLLAPSED isTransitioningTo MenuState.EXPANDED -> {
                tween(durationMillis = 300)
            }

            else -> {
                snap()
            }
        }
    }, label = "") {
        when (it) {
            MenuState.EXPANDED -> 20.dp
            MenuState.COLLAPSED -> 0.dp
        }
    }

    val menuOffset = updateAnim.animateOffset({
        when {
            MenuState.EXPANDED isTransitioningTo MenuState.COLLAPSED -> {
                tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            }

            MenuState.COLLAPSED isTransitioningTo MenuState.EXPANDED -> {
                tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            }

            else -> {
                snap()
            }
        }
    }, label = "") {
        when (it) {
            MenuState.EXPANDED -> Offset(0f, 0f)
            MenuState.COLLAPSED -> Offset(-100f, 0f)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)  ///<<<<<<<<<<<<
    ) {

        //side menu
        MenuComponent(
            Modifier
                .offset {
                    IntOffset(
                        menuOffset.value.x.roundToInt(),
                        menuOffset.value.y.roundToInt()
                    )
                }
                .alpha(alphaMenu.value),
        ) {
            when (it) {
                is HomeMenuAction.MenuSelected -> {
                    screen = it.menu.name
                }

                HomeMenuAction.SETTINGS -> {
                    screen = "SETTINGS"
                }

                HomeMenuAction.LOGOUT -> {
                    //do logout
                }

                else -> {
                    currentState = MenuState.COLLAPSED
                }
            }
            currentState = MenuState.COLLAPSED
        }

        // stack layer 0
        Box(
            modifier = Modifier
                .fillMaxSize()
                .scale(scale.value - 0.05f)
                .offset {
                    IntOffset(
                        transitionOffset.value.x.toInt() - 50,
                        transitionOffset.value.y.toInt()
                    )
                }
                .background(Color(0xFFF3F6FA).copy(alpha = .90f), shape = RoundedCornerShape(20.dp))
                .padding(8.dp)
                .alpha(alphaMenu.value)
        )
        //stack layer 1
        Box(
            modifier = Modifier
                .fillMaxSize()
                .scale(scale.value - 0.08f)
                .offset {
                    IntOffset(
                        transitionOffset.value.x.toInt() - 100,
                        transitionOffset.value.y.toInt()
                    )
                }
                .background(
                    Color(0xFFF3F6FA).copy(.5f), shape = RoundedCornerShape(20.dp)
                )
                .padding(8.dp)
                .alpha(alphaMenu.value)
        )


        // dashboard content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .scale(scale.value)
                .offset {
                    IntOffset(
                        transitionOffset.value.x.toInt(),
                        transitionOffset.value.y.toInt()
                    )
                }
                .clip(shape = RoundedCornerShape(roundness.value))
//                .background(color = colorResource(id = R.color.gray_9))
                .background(
                    Color(0xFFF3F6FA).copy(.8f), shape = RoundedCornerShape(20.dp)
                )
//                .background(color = colorResource(id = R.color.gray_10))

        )
        {
            SpaceHeight25()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Surface(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            currentState = when (currentState) {
                                MenuState.EXPANDED -> MenuState.COLLAPSED
                                MenuState.COLLAPSED -> MenuState.EXPANDED
                            }
                        },
                    shape = RoundedCornerShape(10.dp),
                    color = Color.White,
                    shadowElevation = 5.dp // Specify the elevation here
                ) {
                    Box(
                        modifier = Modifier.size(40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "Menu",
                            modifier = Modifier.size(18.dp),
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.black))
                        )
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
            }

            when (screen) {
                HomeMenu.HOME.name -> {
                    HomeScreen()
                }

                HomeMenu.MY_PROFILE.name -> {
                    ProfileScreen()
                }

            }
        }

    }
}

@Composable
fun MenuComponent(
    modifier: Modifier = Modifier,
    menuAction: (HomeMenuAction) -> Unit = {}
) {

    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Column {
            Image(
                painter = painterResource(id = R.drawable.profile_pic),
                contentDescription = "profile pic",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(shape = CircleShape),
            )


            SpaceHeight8()

            Text(
                text = "Eljad Eendaz",
                fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                color = Color.Black,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp),
                fontFamily = gilroySemiBold()
            )

            Text(
                text = "prelookstudio@gmail.com",
                fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
                color = Color.Black,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp),
                fontFamily = gilroySemiBold()

            )

        }

        Spacer(modifier = Modifier.weight(1f))

        LazyColumn {

            items(HomeMenu.entries.toTypedArray()) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 26.dp, bottom = 16.dp)
                        .clickable {
                            menuAction(HomeMenuAction.MenuSelected(it))
                        }
                ) {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = it.title,
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = it.title,
                        color = Color.Black,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 16.dp),
                        fontWeight = FontWeight.Medium,
                        fontFamily = gilroySemiBold()
                    )
                }

            }
        }

        Spacer(modifier = Modifier.weight(1f))

        //settings
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
                .clickable {
                    menuAction(HomeMenuAction.SETTINGS)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.setting),
                contentDescription = "Settings",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Settings",
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 16.dp),
                fontWeight = FontWeight.Medium
            )
        }


        //logout
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
                .clickable {
                    menuAction(HomeMenuAction.LOGOUT)
                }
        ) {


            Image(painter = painterResource(id = R.drawable.log_out_ic), contentDescription = "")

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Logout",
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 16.dp),
                fontWeight = FontWeight.Medium
            )
        }

        //app version
//        Text(
//            text = "App version: 124",
//            color = Color.Black.copy(alpha = .2f),
//            fontSize = 16.sp,
//            modifier = Modifier.padding(start = 16.dp),
//            fontWeight = FontWeight.Medium,
//        )

    }

}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewHomeComponent() {
    SlidingMenu()
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewMenuComponent() {
    MenuComponent()
}