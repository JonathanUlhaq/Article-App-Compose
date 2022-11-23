package com.belajar.articleapp.routes

sealed class Routes(val route:String) {
    object Home:Routes("home")
    object Detail:Routes("detail")
    object Article:Routes("article")
    object Comment:Routes("comment")
    object Similar:Routes("similar")
    object Route:Routes("routes")
}
