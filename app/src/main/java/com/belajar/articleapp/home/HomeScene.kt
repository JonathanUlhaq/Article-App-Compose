package com.belajar.articleapp.home

import android.graphics.ColorFilter
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.articleapp.R
import com.belajar.articleapp.bottomanv.BottomNavBar
import com.belajar.articleapp.routes.Routes

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {

}

@Composable
fun HomeLayout(
    navController: NavController
) {

    Scaffold(
        topBar = {
            TopBar()
        },
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = {
        BottomNavBar()
        }
    ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(start = 24.dp)
            ) {
                GreetingTitle()
                Spacer(modifier = Modifier.height(16.dp))
                Categories()
                Spacer(modifier = Modifier.height(16.dp))
                Articles(navController)

            }
    }
}

@Composable
fun Articles(
    navController:NavController
) {
    val title = listOf(
        "Why We Love Music",
        "Leslar Vs Randy Orton",
        "How Game Make Us Happy",
        "My Name is Shiva",
        "Hacker Must Die",
        "Alien is Real",
        "Viral Ini kenapa Indonesia disebut Atlantis"
    )

    val date = listOf(
        "12 min ago",
        "16 min ago",
        "17 min ago",
        "18 min ago",
        "19 min ago",
        "11 min ago",
        "9 min ago",
    )

    val content = listOf(
        "Researchers are discovering how music affects the brain, helping us to make sense of its real emotional and social power...",
        "Researchers are discovering how music affects the brain, helping us to make sense of its real emotional and social power...",
        "Researchers are discovering how music affects the brain, helping us to make sense of its real emotional and social power...",
        "Researchers are discovering how music affects the brain, helping us to make sense of its real emotional and social power...",
        "Researchers are discovering how music affects the brain, helping us to make sense of its real emotional and social power...",
        "Researchers are discovering how music affects the brain, helping us to make sense of its real emotional and social power...",
        "Researchers are discovering how music affects the brain, helping us to make sense of its real emotional and social power..."

        )

    val image = listOf(
        R.drawable.gambar_dj,
        R.drawable.gambar_dj,
        R.drawable.gambar_dj,
        R.drawable.gambar_dj,
        R.drawable.gambar_dj,
        R.drawable.gambar_dj,
        R.drawable.gambar_dj
    )

    LazyColumn(content ={
        itemsIndexed(image) { index,item ->
            Spacer(modifier = Modifier.height(16.dp))
            ArticleItem(title = title[index] , date = date[index] , content = content[index] , gambar = item ) {
                navController.navigate(Routes.Detail.route+"/${title[index]}")
            }
        }
    })
}

@Composable
fun ArticleItem(
    title:String,
    date:String,
    content:String,
    gambar:Int,
    onClick:() -> Unit
) {
    Card(
        backgroundColor = MaterialTheme.colors.secondary,
        modifier = Modifier
            .padding(end = 24.dp)
            .clickable { onClick.invoke() },
        shape = RoundedCornerShape(20.dp),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                        ) {
                    Image(painter = painterResource(id = R.drawable.account_profile),
                        contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(text = title,
                            style = MaterialTheme.typography.h2,
                            color = MaterialTheme.colors.primary)
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = date,
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.onSecondary)
                    }
                }
            
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = content,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.surface)

            Spacer(modifier = Modifier.height(24.dp))

            Image(painter = painterResource(id = gambar),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp)))
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun Categories() {
    val category = listOf(
        "Music",
        "Pet",
        "Technology",
        "Healthy",
        "Religion",
        "Nature",
        "Conflict",
        "Murder",
        "Killer",
        "Game",
        "Sport",
        "Anime"
    )

    var current:Int? by remember {
        mutableStateOf(null)
    }

    var selected by remember {
        mutableStateOf(false)
    }

    LazyRow(content ={
        itemsIndexed(category) { index,item ->
            selected = index == current
            CategoryItem(category = item, currentCategory = selected ) {
                current = index
            }
        }
    })

}

@Composable
fun CategoryItem(
    category:String,
    currentCategory:Boolean,
    clickCategories:() -> Unit
) {
    val colorFont by animateColorAsState(targetValue = if (currentCategory) MaterialTheme.colors.background else MaterialTheme.colors.primary)
    val colorCard by animateColorAsState(targetValue = if (currentCategory) MaterialTheme.colors.primary else MaterialTheme.colors.secondary)

    Button(onClick = {clickCategories.invoke()},
        shape = RoundedCornerShape(100),
        modifier = Modifier
            .padding(end = 10.dp),
        colors = ButtonDefaults.buttonColors(colorCard)) {

            Text(text = category,
                style = MaterialTheme.typography.h2,
                color = colorFont,
            )


    }

}

@Composable
fun GreetingTitle() {
    Text(text = "Hi, Tommy what do you want to read",
        color = MaterialTheme.colors.primary,
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .padding(8.dp))
}

@Composable
fun TopBar() {
    Row(Modifier.padding(start = 24.dp, top = 48.dp)) {

        IconButton(onClick = { /*TODO*/ }) {
            Card(
                shape = CircleShape,
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                Icon(painter = painterResource(id = R.drawable.menu),
                    contentDescription = null,
                    modifier = Modifier.padding(4.dp))
            }
        }
    }
}