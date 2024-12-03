package com.example.navigatorjetpackcompose

sealed class Screens(val name: String) {
    object HomeScreen: Screens("home")
    object AddScreen: Screens("adduser")
    object ContactScreen: Screens("contact")
}