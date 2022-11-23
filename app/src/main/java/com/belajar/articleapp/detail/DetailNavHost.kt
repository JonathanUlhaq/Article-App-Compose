package com.belajar.articleapp.detail

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
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
fun NavigationAdapterDetail(
    state:LazyListState,
    navHost:NavHostController,
    selected:Boolean,
    index:Int
) {

    AnimatedNavHost(navController = navHost, startDestination = Routes.Article.route) {

        composable(route = Routes.Article.route,
            enterTransition = {
               when(selected) {
                   true -> { slideIntoContainer(AnimatedContentScope.SlideDirection.Right, tween(700))}
                   else -> { slideIntoContainer(AnimatedContentScope.SlideDirection.Right, tween(700))}
               }
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, tween(700))
            }) {
            ContentArticle(state = state )
        }

        composable(route = Routes.Comment.route,
            enterTransition = {
                when(selected) {
                    true -> {
                        when(index){
                            1 -> {slideIntoContainer(AnimatedContentScope.SlideDirection.Right, tween(700))}
                            else -> {slideIntoContainer(AnimatedContentScope.SlideDirection.Right, tween(700))}
                        }
                    }
                    else -> {
                        when(index){
                            1 -> {slideIntoContainer(AnimatedContentScope.SlideDirection.Left, tween(700))}
                            else -> {slideIntoContainer(AnimatedContentScope.SlideDirection.Right, tween(700))}
                        }
                    }
                }
            },
            exitTransition = {
                when(selected) {
                    true -> { slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, tween(700))  }
                    else -> {
                        when(index){
                            0 -> {slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, tween(700))}
                            else -> {slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, tween(700))}
                        }
                    }
                }
            }) {
            ContentArticle(state = state )
        }

        composable(route = Routes.Similar.route,
            enterTransition = {
                when(selected) {
                    true -> { slideIntoContainer(AnimatedContentScope.SlideDirection.Left, tween(700))}
                    else -> { slideIntoContainer(AnimatedContentScope.SlideDirection.Left, tween(700))}
                }            },
            exitTransition = {
                when(selected) {
                    true -> { slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, tween(700))}
                    else -> { slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, tween(700))}
                }
            }) {
            ContentArticle(state = state )
        }
    }
}