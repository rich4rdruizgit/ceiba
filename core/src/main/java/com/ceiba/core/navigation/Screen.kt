package com.ceiba.core.navigation

sealed class Screen(val route: String){
    object ListUserScreen: Screen("list_user_screen")
    object PostScreen: Screen("post_screen")
}

