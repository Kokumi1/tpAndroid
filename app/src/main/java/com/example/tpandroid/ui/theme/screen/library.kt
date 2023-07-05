package com.example.tpandroid.ui.theme.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tpandroid.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Library() {
    var type by remember { mutableStateOf(0) }
    Scaffold(modifier = Modifier.background(colorResource(id = R.color.background)),
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Row(modifier = Modifier.background(colorResource(id = R.color.background))) {
                            Text(
                                text = stringResource(id = R.string.library_title_music),
                                color = Color.White
                            )
                            Text(
                                modifier = Modifier.padding(start = 20.dp),
                                text = stringResource(id = R.string.library_title_podcasts),
                                color = Color.Gray
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = colorResource(id = R.color.background)
                    )
                )
                NavigationBar(
                    containerColor = colorResource(id = R.color.background),
                    contentColor = Color.DarkGray
                ) {
                    NavigationBarItem(
                        selected = type == 0,
                        onClick = { type = 0},
                        icon = {
                            Text(text = stringResource(id = R.string.library_nav_playlist), color = if(type!=0) Color.White else Color.Black)
                        })

                    NavigationBarItem(
                        selected = type == 1,
                        onClick = { type = 1},
                        icon = {
                            Text(text = stringResource(id = R.string.library_nav_artists), color = if(type!=1) Color.White else Color.Black)
                        })
                    NavigationBarItem(
                        selected = type == 2,
                        onClick = { type = 2},
                        icon = {
                            Text(text = stringResource(id = R.string.library_nav_albums), color = if(type!=2) Color.White else Color.Black)
                        })
                }
            }


        }
    ) {
        LazyColumn(
            modifier = Modifier
                .background(color = colorResource(id = R.color.background))
                .fillMaxWidth()
        ) {
            when (type) {
                /**
                Playlists
                 */
                0 -> {
                    item {
                        Spacer(modifier = Modifier.padding(top = 110.dp))
                    }
                    items(8) { index ->
                        Row(modifier = Modifier.padding(top = 20.dp, start = 20.dp)) {
                            Image(
                                modifier = Modifier
                                    .height(110.dp)
                                    .width(110.dp),
                                painter = painterResource(
                                    id =
                                    when (index) {
                                        0 -> R.drawable.ic_add
                                        1 -> R.drawable.acdc
                                        2 -> R.drawable.gazo
                                        3 -> R.drawable.peter_crowley
                                        4 -> R.drawable.sabaton
                                        5 -> R.drawable.phil_collins
                                        6 -> R.drawable.peter_crowley
                                        7 -> R.drawable.telephone
                                        else -> R.drawable.phil_collins
                                    }
                                ),
                                contentScale = ContentScale.Crop,
                                contentDescription = "artist image"
                            )
                            Column(
                                modifier = Modifier
                                    .padding(
                                        top = if (index != 0) 35.dp else 42.dp,
                                        start = 10.dp
                                    )
                            ) {
                                Text(
                                    color = Color.White,
                                    text = when (index) {
                                        0 -> "Create playlists"
                                        1 -> "ACDC"
                                        2 -> "Gazo"
                                        3 -> "Peter Crowley"
                                        4 -> "Sabaton"
                                        5 -> "Phil Collins"
                                        6 -> "Peter Crowley"
                                        7 -> "Telephone"
                                        else -> "No one"
                                    }
                                )
                                if (index != 0) Text(
                                    color = Color.LightGray,
                                    text = when (index) {
                                        1 -> "5 songs"
                                        2 -> "6 songs"
                                        3 -> "21 songs"
                                        4 -> "8 songs"
                                        5 -> "11 songs"
                                        6 -> "21 songs"
                                        7 -> "8 songs"
                                        else -> "No one"
                                    }
                                )
                            }

                        }
                    }
                }

                /**
                Artist
                 */
                1 -> {
                    item {
                        Spacer(modifier = Modifier.padding(top = 110.dp))
                    }
                    items(8) { index ->
                        Row(modifier = Modifier.padding(top = 10.dp, start = 20.dp)) {
                            Image(
                                modifier = Modifier
                                    .height(110.dp)
                                    .width(110.dp)
                                    .clip(shape = CircleShape),
                                painter = painterResource(
                                    id =
                                    when (index) {
                                        0 -> R.drawable.phil_collins
                                        1 -> R.drawable.acdc
                                        2 -> R.drawable.gazo
                                        3 -> R.drawable.peter_crowley
                                        4 -> R.drawable.sabaton
                                        5 -> R.drawable.phil_collins
                                        6 -> R.drawable.peter_crowley
                                        7 -> R.drawable.telephone
                                        else -> R.drawable.phil_collins
                                    }
                                ),
                                contentScale = ContentScale.Crop,
                                contentDescription = "artist image"
                            )
                            Column(modifier = Modifier.padding(top = 30.dp, start = 10.dp)) {
                                Text(
                                    color = Color.White,
                                    text = when (index) {
                                        0 -> "Phil Collins"
                                        1 -> "ACDC"
                                        2 -> "Gazo"
                                        3 -> "Peter Crowley"
                                        4 -> "Sabaton"
                                        5 -> "Phil Collins"
                                        6 -> "Peter Crowley"
                                        7 -> "Telephone"
                                        else -> "No one"
                                    }
                                )
                                Text(
                                    color = Color.LightGray,
                                    text = when (index) {
                                        0 -> "11 songs"
                                        1 -> "5 songs"
                                        2 -> "6 songs"
                                        3 -> "21 songs"
                                        4 -> "8 songs"
                                        5 -> "11 songs"
                                        6 -> "21 songs"
                                        7 -> "8 songs"
                                        else -> "No one"
                                    }
                                )
                            }

                        }
                    }
                }

                /**
                Albums
                 */
                2 -> {
                    item {
                        Spacer(modifier = Modifier.padding(top = 110.dp))
                    }
                    items(8) { index ->
                        Row(modifier = Modifier.padding(top = 10.dp, start = 20.dp)) {
                            Image(
                                modifier = Modifier
                                    .height(110.dp)
                                    .width(110.dp)
                                    .clip(shape = CircleShape),
                                painter = painterResource(
                                    id =
                                    when (index) {
                                        0 -> R.drawable.phil_collins
                                        1 -> R.drawable.acdc
                                        2 -> R.drawable.gazo
                                        3 -> R.drawable.peter_crowley
                                        4 -> R.drawable.sabaton
                                        5 -> R.drawable.phil_collins
                                        6 -> R.drawable.peter_crowley
                                        7 -> R.drawable.telephone
                                        else -> R.drawable.phil_collins
                                    }
                                ),
                                contentScale = ContentScale.Crop,
                                contentDescription = "artist image"
                            )
                            Column(modifier = Modifier.padding(top = 30.dp, start = 10.dp)) {
                                Text(
                                    color = Color.White,
                                    text = when (index) {
                                        0 -> "Going Back"
                                        1 -> "Highway to Hell"
                                        2 -> "KMT"
                                        3 -> "Conquest of the Seven Seas"
                                        4 -> "The Art of War"
                                        5 -> "Both Sides"
                                        6 -> "Collection #10"
                                        7 -> "Dure Limite"
                                        else -> "No one"
                                    }
                                )
                                Text(
                                    color = Color.LightGray,
                                    text = when (index) {
                                        0 -> "Phil Collins"
                                        1 -> "ACDC"
                                        2 -> "Gazo"
                                        3 -> "Peter Crowley"
                                        4 -> "Sabaton"
                                        5 -> "Phil Collins"
                                        6 -> "Peter Crowley"
                                        7 -> "Téléphone"
                                        else -> "No one"
                                    }
                                )
                            }

                        }
                    }
                }

                else -> {
                    items(8) { index ->
                        Column {
                            Image(
                                modifier = Modifier
                                    .height(100.dp)
                                    .width(100.dp),
                                painter = painterResource(
                                    id =
                                    when (index) {
                                        0 -> R.drawable.phil_collins
                                        1 -> R.drawable.acdc
                                        2 -> R.drawable.gazo
                                        3 -> R.drawable.peter_crowley
                                        4 -> R.drawable.sabaton
                                        5 -> R.drawable.phil_collins
                                        6 -> R.drawable.peter_crowley
                                        7 -> R.drawable.telephone
                                        else -> R.drawable.phil_collins
                                    }
                                ),
                                contentDescription = ""
                            )
                            Text(
                                text = when (index) {
                                    0 -> "Phil Collins"
                                    1 -> "ACDC"
                                    2 -> "Gazo"
                                    3 -> "Peter Crowley"
                                    4 -> "Sabaton"
                                    5 -> "Phil Collins"
                                    6 -> "Peter Crowley"
                                    7 -> "Telephone"
                                    else -> "No one"
                                }
                            )
                        }
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun PreviewLibrary() {
    Library()
}