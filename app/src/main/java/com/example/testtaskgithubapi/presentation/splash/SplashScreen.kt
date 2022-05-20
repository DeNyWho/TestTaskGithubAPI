package com.example.testtaskgithubapi.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.testtaskgithubapi.R
import com.example.testtaskgithubapi.navigation.Screen
import com.example.testtaskgithubapi.ui.theme.BlackBackground
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    LaunchedEffect(Unit){
        delay(2000)
        navController.navigate(Screen.Home.route)
    }
    if(isSystemInDarkTheme()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BlackBackground),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.github_mark_light_120px_plus),
                contentDescription = "logo_mark",
                modifier = Modifier.fillMaxSize(0.3f)
            )

            Image(
                painter = painterResource(id = R.drawable.github_logo_white),
                contentDescription = "logo",
                modifier = Modifier.fillMaxSize(0.4f)

            )
        }

    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.github_mark_120px_plus),
                contentDescription = "logo_mark",
                modifier = Modifier.fillMaxSize(0.3f)
            )

            Image(
                painter = painterResource(id = R.drawable.github_logo),
                contentDescription = "logo",
                modifier = Modifier.fillMaxSize(0.4f)

            )
        }
    }
}


