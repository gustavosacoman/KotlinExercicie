package com.example.projetoteste.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    object Welcome : Screen("welcome_screen/{name}") {
        fun createRoute(name: String) = "welcome_screen/$name"
    }
    object Settings : Screen("settings_screen/{name}") {
        fun createRoute(name: String) = "settings_screen/$name"
    }
}