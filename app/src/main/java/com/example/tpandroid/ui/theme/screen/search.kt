package com.example.tpandroid.ui.theme.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tpandroid.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search() {
    var searchText by remember { mutableStateOf("") }
    Column(modifier = Modifier.background(Color.White)) {
        Row(modifier = Modifier.padding(top = 5.dp)) {
            TextField(value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier
                    .padding(2.dp)
                    .width(330.dp),
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {
                    IconButton(onClick = { searchText = "" }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clear),
                            contentDescription = "",

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
                onClick = { searchText = "" },
                modifier = Modifier.padding(top = 20.dp, start = 5.dp)
            )
        }
        LazyRow(modifier = Modifier.padding(start = 5.dp)) {
            items(5) { index ->
                Card(modifier = Modifier.padding(top = 5.dp, end = 5.dp)) {
                    ClickableText(
                        text = AnnotatedString(
                            when (index) {
                                0 -> "Top"
                                1 -> "Artist"
                                2 -> "Songs"
                                3 -> "Playlists"
                                4 -> "Album"
                                else -> "Top"
                            }
                        ), onClick = {}, modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                    )
                }
            }
        }
        Row(Modifier.padding(top = 10.dp, start = 5.dp)) {
            Image(
                painter = painterResource(id = R.drawable.peter_crowley),
                contentDescription = "songs image",
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(start = 5.dp)) {
                Text(text = "Peter Crowley")
                Text(text = "Artist")
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_continue),
                    contentDescription = "action",
                    modifier = Modifier.padding(end = 10.dp)
                )
            }

        }
        Text(text = "Featuring $searchText", modifier = Modifier.size(10.dp))
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)) {
            items(5) { index ->
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
                            else -> "No one"
                        }
                    )
                }
            }
        }
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)) {
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
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_continue),
                            contentDescription = "action",
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSearch() {
    Search()
}