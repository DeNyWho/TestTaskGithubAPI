package com.example.testtaskgithubapi

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testtaskgithubapi.core.DispatchersProvider
import com.example.testtaskgithubapi.navigation.Screen
import com.example.testtaskgithubapi.presentation.search.Search
import com.example.testtaskgithubapi.presentation.search.SearchViewModel
import com.example.testtaskgithubapi.presentation.splash.SplashScreen
import com.example.testtaskgithubapi.ui.theme.BlackBackground
import com.example.testtaskgithubapi.ui.theme.TestTaskGithubAPITheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var dispatchers: DispatchersProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTaskGithubAPITheme {
                ProvideWindowInsets {
                    MyApp(
                        window = window,
                        dispatchers = dispatchers
                    )
                }
            }
        }
    }
}


@Composable
fun MyApp(window: Window, dispatchers: DispatchersProvider) {
    val systemUiController = rememberSystemUiController()
    val navController = rememberNavController()

    
    NavHost(navController = navController, startDestination = Screen.Splash.route ){
        composable(Screen.Splash.route){
            if(!isSystemInDarkTheme()) {
                OnDestinationChanged(
                    systemUiController = systemUiController,
                    color = Color.White,
                    drawOverStatusBar = false,
                    window = window
                )
            }
            else {
                OnDestinationChanged(
                    systemUiController = systemUiController,
                    color = BlackBackground,
                    drawOverStatusBar = false,
                    window = window
                )
            }

            SplashScreen (navController = navController)
        }

        composable(Screen.Search.route) {
            if(!isSystemInDarkTheme()) {
                OnDestinationChanged(
                    systemUiController = systemUiController,
                    color = Color.White,
                    drawOverStatusBar = false,
                    window = window
                )
            }
            else {
                OnDestinationChanged(
                    systemUiController = systemUiController,
                    color = BlackBackground,
                    drawOverStatusBar = false,
                    window = window
                )
            }

            val searchViewModel = hiltViewModel<SearchViewModel>()

            Search(viewModel = searchViewModel, dispatchers = dispatchers)
        }
    }

}



































