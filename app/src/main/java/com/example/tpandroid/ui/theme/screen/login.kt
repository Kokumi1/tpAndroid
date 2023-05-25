package com.example.tpandroid.ui.theme.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {
    val emailTextField = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val passwordTextFieldValue = remember {
        mutableStateOf(TextFieldValue(""))
    }


    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            TextField(
                value = emailTextField.value, onValueChange = { email ->
                    emailTextField.value = email
                }, placeholder = { Text(text = "je suis un placeholder") }
            )

            TextField(value = passwordTextFieldValue.value, onValueChange = { password ->
                passwordTextFieldValue.value = password
            })

            Button(onClick = {
                val firebaseAuth = Firebase.auth
                Log.i("Auth", "register begin")

                firebaseAuth.createUserWithEmailAndPassword(
                    emailTextField.value.text, passwordTextFieldValue.value.text
                )
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.i("Auth", "login complete!!")
                        } else if (task.isCanceled) {
                            Log.e("Auth", "What are you doing?!")
                        }
                    }.addOnFailureListener {
                        Log.e("Auth", "mission failed!")
                    }
            }) {
                Text(text = "register")
            }
        }


    }
}