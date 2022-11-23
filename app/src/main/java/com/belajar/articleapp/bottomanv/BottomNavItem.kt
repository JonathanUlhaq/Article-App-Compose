package com.belajar.articleapp.bottomanv

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belajar.articleapp.R

sealed class BottomNavItem(var label:String ="", var icon:Int) {
    object Home:BottomNavItem("Home", R.drawable.home)
    object Add:BottomNavItem(icon = R.drawable.add)
    object Profile:BottomNavItem("Profile", R.drawable.profile)
}

@Composable
fun BottomNavBar() {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Add,
        BottomNavItem.Profile
    )
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.secondary,
            modifier = Modifier
                .height(120.dp)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                ,

        ) {

            items.forEach {
                BottomNavigationItem(selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(painter = painterResource(id = it.icon),
                            contentDescription = null )
                    },
                    label = {
                        Text(text = it.label,
                            style = MaterialTheme.typography.h2,
                            fontSize = 12.sp)
                    },
                    alwaysShowLabel = true,
                    selectedContentColor = MaterialTheme.colors.secondary,
                    unselectedContentColor = MaterialTheme.colors.primary
                )
            }
        }

}

