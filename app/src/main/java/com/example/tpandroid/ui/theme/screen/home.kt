package com.example.tpandroid.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tpandroid.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.home_meeting)) },
                actions = {
                    IconButton(onClick = {}) {
                        //History button
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_clock),
                                contentDescription = " "
                            )
                        }

                    }
                    IconButton(onClick = {}) {
                        //Settings
                        Icon(
                            painter = painterResource(id = R.drawable.ic_setting),
                            modifier = Modifier.padding(start= 2.dp),
                            contentDescription = " "
                        )
                    }
                }
            )
        },
        /*BottomAppBar(
            containerColor = Color.Black
        ) {
            Image(
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp),
                painter = painterResource(id = R.drawable.phil_collins),
                contentDescription = ""
            )
            Column {
                Text(text = "Do you Remember", color = Color.White)
                Text(text = "Phil Collins", color = Color.White)
            }
            NavigationBarItem(
                selected = true,
                onClick = { },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_tv),
                        contentDescription = " "
                    )
                })
            var onPlay by remember { mutableStateOf(false) }
            NavigationBarItem(
                selected = true,
                onClick = {
                    onPlay = !onPlay
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id =
                            if (onPlay) R.drawable.ic_pause
                            else R.drawable.ic_play
                        ),
                        contentDescription = " "
                    )
                })
        }*/
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .background(Color.Black)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Chip(text = "Tag 1", onClick = {})
                Spacer(modifier = Modifier.width(12.dp))
                Chip(text = "Tag 2", onClick = {})
                Spacer(modifier = Modifier.width(12.dp))
                Chip(text = "Tag 3", onClick = {})
                Spacer(modifier = Modifier.width(12.dp))
            }

            Spacer(modifier = Modifier.padding(12.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(6) { index ->
                    Card(
                        onClick = {}, modifier = Modifier
                            .weight(0.10f)
                    ) {
                        Row {
                            Image(
                                modifier = Modifier
                                    .height(80.dp)
                                    .width(80.dp),
                                painter = painterResource(
                                    id =
                                    when (index) {
                                        0 -> R.drawable.phil_collins
                                        1 -> R.drawable.acdc
                                        2 -> R.drawable.gazo
                                        3 -> R.drawable.peter_crowley
                                        4 -> R.drawable.sabaton
                                        5 -> R.drawable.telephone
                                        else -> R.drawable.phil_collins
                                    }
                                ),
                                contentScale = ContentScale.Crop,
                                contentDescription = ""
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(80.dp)
                                    .padding(8.dp),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Text(
                                    text =
                                    when (index) {
                                        0 -> "Phil Collins"
                                        1 -> "ACDC"
                                        2 -> "Gazo"
                                        3 -> "Peter Crowley"
                                        4 -> "Sabaton"
                                        5 -> "Téléphone"
                                        else -> "Phil Collins"
                                    }
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.padding(top = 12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // New Release Line
                Card(onClick = {}, modifier = Modifier.weight(0.10f)) {
                    Row(modifier = Modifier.background(Color.Black)) {
                        AsyncImage(
                            modifier = Modifier
                                .height(60.dp)
                                .width(60.dp)
                                .clip(CircleShape),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://images.unsplash.com/photo-1679678691007-d663208cebd5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=736&q=80")
                                .build(),
                            contentDescription = ""
                        )
                        Column {
                            Text(
                                text = stringResource(id = R.string.home_new), modifier = Modifier.fillMaxWidth(),
                                color = Color.White
                            )
                            Text(
                                text = "Pseudonym", modifier = Modifier.fillMaxWidth(),
                                color = Color.White
                            )
                        }

                    }
                }

            }
            Spacer(modifier = Modifier.padding(top = 6.dp))
            Row {
                Card(
                    onClick = {}, modifier = Modifier
                        .weight(0.10f)
                        .fillMaxWidth()
                    //.background(Color.DarkGray)
                ) {
                    Row {
                        AsyncImage(
                            modifier = Modifier
                                .height(120.dp)
                                .width(120.dp),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://images.unsplash.com/photo-1679678691007-d663208cebd5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=736&q=80")
                                .build(),
                            contentScale = ContentScale.Crop,
                            contentDescription = ""
                        )
                        Column(
                            modifier = Modifier
                                .background(Color.Gray)
                                .padding(start = 5.dp)
                        ) {
                            Text(
                                text = "Do you remember",
                                modifier = Modifier.fillMaxWidth(),
                                color = Color.White
                            )
                            Text(
                                text = "Pseudonym",
                                modifier = Modifier.fillMaxWidth(),
                                color = Color.White
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 12.dp, top = 50.dp),
                                horizontalArrangement = SpaceBetween
                            ) {
                                Icon(
                                    //Like button
                                    painter = painterResource(
                                        id =
                                        R.drawable.ic_heart_empty
                                    ),
                                    contentDescription = " ",
                                    modifier = Modifier
                                        .clickable { }
                                        .align(Alignment.CenterVertically)
                                        .padding(start = 12.dp),
                                )
                                //Play button
                                Box(modifier = Modifier
                                    .padding(end= 12.dp)
                                    .align(Alignment.CenterVertically)
                                    .clickable {}
                                    .clip(CircleShape)
                                    .background(Color.White)) {
                                    Icon(
                                        painter = painterResource(
                                            id =
                                            R.drawable.ic_play
                                        ),
                                        contentDescription = " "
                                    )
                                }

                            }
                        }

                    }
                }
            }

            Text(
                text = stringResource(id = R.string.home_rotation),
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .size(width = 300.dp, height = 30.dp)
                    .fillMaxWidth()
            )
            LazyRow {
                //Rotation
                items(5) { index ->
                    Card(
                        onClick = {}, modifier = Modifier
                            .weight(0.10f)
                            .padding(10.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .height(160.dp)
                                .width(160.dp),
                            painter = painterResource(
                                id =
                                when (index) {
                                    0 -> R.drawable.phil_collins
                                    1 -> R.drawable.acdc
                                    2 -> R.drawable.gazo
                                    3 -> R.drawable.peter_crowley
                                    4 -> R.drawable.sabaton
                                    5 -> R.drawable.telephone
                                    else -> R.drawable.phil_collins
                                }
                            ),
                            contentScale = ContentScale.Crop,
                            contentDescription = ""
                        )


                    }
                }
            }
        }
    }
}

@Composable
fun Chip(text: String, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.clickable(onClick = onClick).padding(top = 5.dp)
    ) {
        Text(text = text, modifier = Modifier.padding(horizontal = 15.dp, vertical = 4.dp))
    }
}

@Preview
@Composable
fun PreviewHome() {
    Home()
}
