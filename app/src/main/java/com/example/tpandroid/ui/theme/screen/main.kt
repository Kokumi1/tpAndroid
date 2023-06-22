package com.example.tpandroid.ui.theme.screen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tpandroid.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.Black,

                ) {
                NavigationBarItem(
                    selected = true,
                    onClick = { navController.navigate("home") },
                    label = { Text(text = "Home") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = " "
                        )

                    })
                NavigationBarItem(
                    selected = true,
                    onClick = { navController.navigate("search") },
                    label = { Text(text = "Search") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = " "
                        )

                    })

                NavigationBarItem(
                    selected = true,
                    onClick = { navController.navigate("library") },
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
        NavHost(navController = navController, startDestination = "login" ){
            composable("home"){
                Home()
            }
            composable("search"){
                Search()
            }
            composable("library"){
                Text(text = "là ya pas")
            }
            composable("login"){
                Login()
            }
        }
    }
}