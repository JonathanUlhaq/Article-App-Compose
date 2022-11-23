package com.belajar.articleapp.animatednav

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.belajar.articleapp.detail.DetailLayout
import com.belajar.articleapp.home.HomeLayout
import com.belajar.articleapp.routes.Routes
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationAdapter() {
    val navHost = rememberAnimatedNavController()
    AnimatedNavHost(navController = navHost, startDestination = Routes.Home.route) {
        composable(Routes.Home.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Up)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Up)
            }) {
            HomeLayout(navHost)
        }
        composable(Routes.Detail.route+"/{title}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                }

            ),
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Up)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Up)
            }) {
            it.arguments?.getString("title")?.let { it1 -> DetailLayout(it1, navController = navHost) }
        }
    }
}