package com.belajar.articleapp.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.belajar.articleapp.R

@Composable
fun ContentArticle (state:LazyListState) {
    Card(
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.secondary,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.padding(start = 24.dp, end = 24.dp),

    ) {
       LazyColumn(
           modifier = Modifier
               .padding(16.dp),
           state = state
       ) {
          items(5) {
              IsiKonten()
          }
       }
    }
}

@Composable
private fun IsiKonten() {
    Text(text = "I still remember when I first heard the song by Peter Gabriel, “Solsbury Hill.” Something about that song—the lyrics, the melody, the unusual 7/4 time signature—gave me chills. Even now, years later, it still can make me cry.",
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.primary)
    Spacer(modifier = Modifier.height(24.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(CenterHorizontally)
            .background(Color.Transparent)
    ) {
        Image(painter = painterResource(id = R.drawable.disc),
            contentDescription = null,
            modifier = Modifier
                .size(290.dp))
    }
    Spacer(modifier = Modifier.height(24.dp))
    Text(text = "Who among us doesn’t have a similar story about a song that touched us? Whether attending a concert, listening to the radio, or singing in the shower, there’s something about music that can fill us with emotion, from joy to sadness.",
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.primary)
    Spacer(modifier = Modifier.height(20.dp))
    Text(text = "Music impacts us in ways that other sounds don’t, and for years now, scientists have been wondering why. Now they are finally beginning to find some answers. Using fMRI technology, they’re discovering why music can inspire such strong feelings and bind us so tightly to other people.",
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.primary)
}


