package com.example.testtaskgithubapi

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.testtaskgithubapi.core.DispatchersProvider
import com.example.testtaskgithubapi.ui.theme.TestTaskGithubAPITheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var dispatchers: DispatchersProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTaskGithubAPITheme {
                MyApp(
                    window = window,
                    dispatchers = dispatchers
                )
            }
        }
    }
}


@Composable
fun MyApp(window: Window, dispatchers: DispatchersProvider) {
    val systemUiController = rememberSystemUiController()
    val navController = rememberNavController()


}
