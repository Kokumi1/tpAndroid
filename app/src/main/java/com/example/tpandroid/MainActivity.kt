package com.example.tpandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tpandroid.ui.theme.TpAndroidTheme
//import com.example.tpandroid.ui.theme.Signup
import com.example.tpandroid.ui.theme.screen.Home
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val firebaseAuth = Firebase.auth
        val firebaseFirestore = Firebase.firestore


        setContent {
            TpAndroidTheme {
                Home()
                //Signup()
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
}
