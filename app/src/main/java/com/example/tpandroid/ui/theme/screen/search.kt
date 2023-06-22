package com.example.tpandroid.ui.theme.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tpandroid.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search() {
    var searchText by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                actions = {
                    Column {
                        Row {

                            TextField(value = searchText,
                                onValueChange = { searchText = it },
                                modifier = Modifier.padding(4.dp),
                                shape = RoundedCornerShape(8.dp),
                                trailingIcon = {
                                    IconButton(onClick = { searchText = "" }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_clear),
                                            contentDescription = ""
                                        )
                                    }
                                },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_search),
                                        contentDescription = "search"
                                    )
                                }
                            )
                            ClickableText(
                                text = AnnotatedString("Cancel"),
                                onClick = { searchText = "" })
                        }
                        LazyRow {
                            items(5) { index ->
                                ClickableText(text = AnnotatedString(
                                    when (index) {
                                        0 -> "Top"
                                        1 -> "Artist"
                                        2 -> "Songs"
                                        3 -> "Playlists"
                                        4 -> "Album"
                                        else -> "Top"
                                    }
                                ), onClick = {})
                            }
                        }
                    }
                }
            )
        }
    )
    {
        Column {
            Card(onClick = {}) {
                Row {
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
                            text = if (searchText == "") "Pseudonym" else searchText,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(text = "Artist", modifier = Modifier.fillMaxWidth())
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_continue),
                            contentDescription = "select"
                        )
                    }

                }
            }
            Text(text = "Featuring $searchText", modifier = Modifier.size(10.dp))
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                item {
                    Column {
                        Image(
                            modifier = Modifier
                                .height(80.dp)
                                .width(80.dp),
                            painter = painterResource(id = R.drawable.phil_collins),
                            contentDescription = ""
                        )
                        Text(text = "Phil Collins")
                    }
                }
                item {
                    Column {
                        Image(
                            modifier = Modifier
                                .height(80.dp)
                                .width(80.dp),
                            painter = painterResource(id = R.drawable.acdc),
                            contentDescription = ""
                        )
                        Text(text = "ACDC")
                    }
                }
                item {
                    Column {
                        Image(
                            modifier = Modifier
                                .height(80.dp)
                                .width(80.dp),
                            painter = painterResource(id = R.drawable.gazo),
                            contentDescription = ""
                        )
                        Text(text = "Gazo")
                    }
                }
                item {
                    Column {
                        Image(
                            modifier = Modifier
                                .height(80.dp)
                                .width(80.dp),
                            painter = painterResource(id = R.drawable.peter_crowley),
                            contentDescription = ""
                        )
                        Text(text = "Peter Crowley")
                    }
                }
            }
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(5) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.peter_crowley),
                            contentDescription = "songs image",
                            modifier = Modifier.width(120.dp)
                        )
                        Column {
                            Text(text = "In the depths of the Church")
                            Text(text = "Songs - Peter Crowley")
                        }
                        Icon(
                            painter = painterResource(id = R.drawable.ic_continue),
                            contentDescription = "action"
                        )
                    }
                }
            }
        }
    }
}