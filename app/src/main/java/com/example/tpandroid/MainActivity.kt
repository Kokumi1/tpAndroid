package com.example.tpandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tpandroid.ui.theme.TpAndroidTheme
import com.example.tpandroid.ui.theme.screen.Login
import com.example.tpandroid.ui.theme.screen.Home
import com.example.tpandroid.ui.theme.screen.Main
import com.example.tpandroid.ui.theme.screen.Search


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            TpAndroidTheme {
                //Main()
                Login()
                //Home()
                //Search()
            }
        }
    }
}
