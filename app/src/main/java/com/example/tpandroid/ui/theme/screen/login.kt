package com.example.tpandroid.ui.theme.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {
    val navController = rememberNavController()
    val emailTextField = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val passwordTextFieldValue = remember {
        mutableStateOf(TextFieldValue(""))
    }
    Scaffold {
        val context = LocalContext.current
        FirebaseApp.initializeApp(context)
        val firebaseAuth = Firebase.auth

        Column(modifier = Modifier.padding(it),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = emailTextField.value, onValueChange = { email ->
                    emailTextField.value = email

                }, placeholder = { Text(text = "email") }
            )

            TextField(value = passwordTextFieldValue.value, onValueChange = { password ->
                passwordTextFieldValue.value = password
            }, placeholder={ Text(text="password")})
            Spacer(modifier = Modifier.padding(12.dp))

            Button(onClick = {

                Log.i("Auth", "register begin")

                firebaseAuth.signInWithEmailAndPassword(
                    emailTextField.value.text, passwordTextFieldValue.value.text)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                           Log.i("AUTH","Login complete")
                            navController.navigate("home")

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                context,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }
            }) {
                Text(text = "login")
            }
            Spacer(modifier = Modifier.padding(20.dp))

            Button(onClick={
                firebaseAuth.createUserWithEmailAndPassword(
                    emailTextField.value.text, passwordTextFieldValue.value.text
                )
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.i("Auth", "register complete!!")

                        } else if (task.isCanceled) {
                            Log.e("Auth", "What are you doing?!")
                        }
                    }.addOnFailureListener {
                        Log.e("Auth", "mission failed!")
                    }
            }){
                Text(text = "register")
            }

        }
    }
}