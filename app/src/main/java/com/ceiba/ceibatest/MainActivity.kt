package com.ceiba.ceibatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.ceiba.ceibatest.ui.theme.CeibaTestTheme
import com.ceiba.core.navigation.Screen
import com.ceiba.core.utils.Constants
import com.ceiba.post_presentation.components.PostScreen
import com.ceiba.users_presentation.list.components.ListUserScreen
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CeibaTestTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.ListUserScreen.route
                ) {
                    composable(route = Screen.ListUserScreen.route) {
                        ListUserScreen(navController = navController)
                    }
                    composable(
                        route = Screen.PostScreen.route + "/{userId}"
                    ) {
                        PostScreen()
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CeibaTestTheme {
        Greeting("Android")
    }
}