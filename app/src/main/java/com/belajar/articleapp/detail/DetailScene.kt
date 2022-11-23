package com.belajar.articleapp.detail

import androidx.compose.animation.*
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.belajar.articleapp.R
import com.belajar.articleapp.home.TopBar
import com.belajar.articleapp.routes.Routes
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DetailLayout(title:String,
    navController: NavController) {


    val state = rememberLazyListState()
    var hidden by remember {
        mutableStateOf(false)
    }
    val percentState = statePercent(state.firstVisibleItemIndex,5,state.layoutInfo.visibleItemsInfo.size)

    hidden = percentState <0.5
    val size by animateIntAsState(targetValue = if (hidden) 120 else 12)
        Box {
            ImageTitle()
            Scaffold(
                topBar = {
                    DetailTopBar() {
                        navController.navigate(Routes.Home.route) {
                           
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                backgroundColor = Color.Transparent
            ) {
                Column(modifier = Modifier
                    .padding(it)) {
                Spacer(modifier = Modifier.height(size.dp))
                AnimatedVisibility(visible = hidden,
                    enter = expandVertically(tween(700), expandFrom = Alignment.Bottom),
                    exit = shrinkVertically(tween(700), shrinkTowards = Alignment.Bottom)
                ) {
                    TitleDetail(title)
                }
                    Spacer(modifier = Modifier.height(15.dp))
                    MainArticle(state)
                }
        }
    }
}


@Composable
fun DetailTopBar(
    onBack:()->Unit
) {
    Row(Modifier.padding(start = 24.dp, top = 48.dp)) {

        IconButton(onClick = { onBack.invoke() }) {
            Card(
                shape = CircleShape,
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.padding(4.dp))
            }
        }
    }
}

fun statePercent(currentIndex:Int,allItem:Int,visible:Int):Float {
    return (currentIndex / (allItem - visible).toFloat()) * 100
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainArticle(
    state:LazyListState,

) {
    val navHost = rememberAnimatedNavController()

    var selected by remember {
        mutableStateOf(false)
    }

    var currentSelected by remember {
        mutableStateOf(0)
    }

    val icon = listOf(
        R.drawable.article,
        R.drawable.comment,
        R.drawable.similiar
    )

    val text = listOf(
        "Article",
        "Comment",
        "Similar"
    )

    val route = listOf(
        Routes.Article.route,
        Routes.Comment.route,
        Routes.Similar.route,
    )
    Card(
        elevation = 0.dp,
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxWidth()
    ) {
       Column {

           LazyRow(
               modifier = Modifier
                   .padding(24.dp)
           ) {
               itemsIndexed(icon) {
                       index,item->
                   selected = currentSelected == index
                   DetailCategories(selected = selected,
                       icon = item , text = text[index]) {
                       currentSelected = index
                       navHost.navigate(route[index]) {
                           navHost.graph.startDestinationRoute?.let {
                               popUpTo(it) {
                                   saveState = true
                               }
                           }
                           launchSingleTop = true
                           restoreState = true
                       }
                   }
               }
           }

        Spacer(modifier = Modifier.height(24.dp))
           NavigationAdapterDetail(state = state, navHost = navHost,selected,currentSelected)
       }
    }
}

@Composable
fun DetailCategories(
    selected:Boolean,
    icon:Int,
    text:String,
    clicked:()->Unit
) {
    val backgroundColor by animateColorAsState(targetValue = if (selected) MaterialTheme.colors.primary else MaterialTheme.colors.secondary)
    val fontColor by animateColorAsState(targetValue = if (selected) MaterialTheme.colors.background else MaterialTheme.colors.primary)

    IconButton(onClick = { clicked.invoke() }) {
        Card(
            shape = RoundedCornerShape(100.dp),
            backgroundColor = backgroundColor,
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Row(
                modifier = Modifier.padding(start = 13.dp, end = 13.dp, top = 8.dp, bottom = 8.dp)
            ) {
                Icon(painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = fontColor)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = text,
                    style = MaterialTheme.typography.h2,
                    fontSize = 12.sp,
                    color =  fontColor)
            }
        }
    }
}

@Composable
fun ImageTitle() {
    Image(painter = painterResource(id = R.drawable.detail_article),
        contentDescription = null )
}

@Composable
fun TitleDetail(
    title:String
) {
    Column(
        modifier = Modifier
            .padding(start = 24.dp)
    ) {
        Card(
            elevation = 0.dp,
            shape = RoundedCornerShape(100.dp),
            backgroundColor = MaterialTheme.colors.secondary
        ) {
            Row (
                modifier = Modifier
                    .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 8.dp)
            ) {
                Text(text = "Music",
                    style = MaterialTheme.typography.h2,
                    fontSize = 12.sp,
                    color = MaterialTheme.colors.primary)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(painter = painterResource(id = R.drawable.headphone),
                    contentDescription = null,
                    tint = MaterialTheme.colors.primary)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(text = title,
            style = MaterialTheme.typography.h1,
            fontSize = 32.sp,
            color = MaterialTheme.colors.surface,
            modifier = Modifier
                .width(326.dp))
        Spacer(modifier = Modifier.height(7.dp))
        Text(text = "15 min ago",
            style = MaterialTheme.typography.body2,
            fontSize = 12.sp,
            color = MaterialTheme.colors.surface )
    }

    
}