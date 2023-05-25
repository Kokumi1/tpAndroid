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
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tpandroid.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Good Morning") },
                actions = {
                    IconButton(onClick = {}) {

                        Row() {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_time),
                                contentDescription = " "
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_clock),
                                contentDescription = " "
                            )
                        }

                    }
                }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.Yellow,

                ) {
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    label = { Text(text = "Home") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = " "
                        )

                    })
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    label = { Text(text = "Search") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = " "
                        )

                    })

                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    label = { Text(text = "Library") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_library_music),
                            contentDescription = " "
                        )

                    })
            }
        }

    ) {


        Column(modifier = Modifier.padding(it)) {

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Chip(text = "Tag 1", onClick = {})
                Spacer(modifier = Modifier.width(12.dp))
                Chip(text = "Tag 2", onClick = {})
                Spacer(modifier = Modifier.width(12.dp))
                Chip(text = "Tag 3", onClick = {})
                Spacer(modifier = Modifier.width(12.dp))
            }

            Spacer(modifier = Modifier.padding(12.dp))

            Row(modifier = Modifier.padding(horizontal = 12.dp)) {
                Card(onClick = {}, modifier = Modifier
                    .weight(0.10f)
                    .background(Color.Green)) {
                    Row() {
                        Image(
                            modifier = Modifier.height(100.dp),
                            painter = painterResource(id = R.drawable.phil_collins),
                            contentDescription = ""
                        )

                        Text(text = "Image")
                    }

                }
                Spacer(modifier = Modifier.padding(12.dp))

                Card(onClick = {}, modifier = Modifier.weight(0.10f)) {
                    Row() {
                        Image(
                            modifier = Modifier.height(100.dp),
                            painter = painterResource(id = R.drawable.acdc),
                            contentDescription = ""
                        )
                        Text(text = "Image")
                    }
                }
            }

            Spacer(modifier = Modifier.padding(top = 6.dp))

            Row(modifier = Modifier.padding(horizontal = 12.dp)) {
                Card(onClick = {}, modifier = Modifier
                    .weight(0.10f)
                    .background(Color.Green)) {
                    Row() {
                        Image(
                            modifier = Modifier.height(100.dp),
                            painter = painterResource(id = R.drawable.gazo),
                            contentDescription = ""
                        )
                        Text(text = "Image")
                    }

                }
                Spacer(modifier = Modifier.padding(12.dp))

                Card(onClick = {}, modifier = Modifier.weight(0.10f)) {
                    Row() {
                        Image(
                            modifier = Modifier.height(100.dp),
                            painter = painterResource(id = R.drawable.peter_crowley),
                            contentDescription = ""
                        )
                        Text(text = "Image")
                    }
                }
            }

            Spacer(modifier = Modifier.padding(top = 6.dp))

            Row(modifier = Modifier.padding(horizontal = 12.dp)) {
                Card(onClick = {}, modifier = Modifier
                    .weight(0.10f)
                    .background(Color.Green)) {
                    Row() {
                        Image(
                            modifier = Modifier.height(100.dp),
                            painter = painterResource(id = R.drawable.sabaton),
                            contentDescription = ""
                        )
                        Text(text = "Image")
                    }

                }
                Spacer(modifier = Modifier.padding(12.dp))

                Card(onClick = {}, modifier = Modifier.weight(0.10f)) {
                    Row() {
                        Image(
                            modifier = Modifier.height(100.dp),
                            painter = painterResource(id = R.drawable.telephone),
                            contentDescription = ""
                        )
                        Text(text = "Image")
                    }
                }
            }

            Spacer(modifier = Modifier.padding(top = 12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Card(onClick = {}, modifier = Modifier.weight(0.10f)) {
                    Row() {
                        AsyncImage(
                            modifier = Modifier
                                .height(100.dp)
                                .clip(CircleShape),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://images.unsplash.com/photo-1679678691007-d663208cebd5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=736&q=80")
                                .build(),
                            contentDescription = ""
                        )
                        Text(text = "Pseudonym", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
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
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Text(text = text, modifier = Modifier.padding(horizontal = 15.dp, vertical = 4.dp),)
    }
}
