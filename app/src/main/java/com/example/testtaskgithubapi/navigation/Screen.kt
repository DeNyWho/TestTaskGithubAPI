package com.example.testtaskgithubapi.navigation

sealed class Screen(val route: String){
    object Splash: Screen("splash_screen")
    object Details: Screen("detail_screen")
    object Search: Screen("search_screen")
}
