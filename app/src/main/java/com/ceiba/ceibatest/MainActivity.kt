package com.ceiba.ceibatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.ceiba.ceibatest.navigation.Route
import com.ceiba.ceibatest.ui.theme.CeibaTestTheme
import com.ceiba.users_presentation.list.components.ListUserScreen
import dagger.hilt.EntryPoint
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
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.LIST_USERS
                    ) {
                        composable(Route.LIST_USERS) {
                            ListUserScreen(
                                scaffoldState = scaffoldState,
                                onNavigateUp = { navController.navigateUp() })
                        }
                        composable(Route.POSTS) {
                            ListUserScreen(
                                scaffoldState = scaffoldState,
                                onNavigateUp = { navController.navigateUp() })
                        }
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