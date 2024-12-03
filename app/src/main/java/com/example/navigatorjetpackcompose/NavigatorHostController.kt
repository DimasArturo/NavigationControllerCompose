package com.example.navigatorjetpackcompose

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigatorjetpackcompose.screens.AddScreen
import com.example.navigatorjetpackcompose.screens.ContactScreen
import com.example.navigatorjetpackcompose.screens.HomeScreen


@Composable
fun NavigatorHostController(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "home",
        enterTransition = {slideIntoContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(300)
        )},
        exitTransition = {slideOutOfContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(300)
        )},

            popEnterTransition =  {slideIntoContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Right,
            animationSpec = tween(300)
        )},
        popExitTransition = {slideOutOfContainer(
            towards = AnimatedContentTransitionScope.SlideDirection.Right,
            animationSpec = tween(300)
        )}

        ){
        composable(route = Screens.HomeScreen.name){ HomeScreen(navController) }
        composable(route = Screens.AddScreen.name){ AddScreen(navController) }
        composable(route = "${Screens.ContactScreen.name}?username={username}",
            arguments = listOf(navArgument("username"){
                defaultValue = "Sin nombre"
            })
        ){ stackEntry ->
            val username = stackEntry.arguments?.getString("username")
            ContactScreen(navController, username)
        }
    }
}