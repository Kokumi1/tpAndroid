package com.example.tpandroid.ui.theme.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tpandroid.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(pNavController: NavController) {

    val failedResource = stringResource(id = R.string.login_failed)
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

        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            //title
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 100.dp)
                    .height(80.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo")

            TextField(
                value = emailTextField.value, onValueChange = { email ->
                    emailTextField.value = email

                }, placeholder = { Text(text = stringResource(id = R.string.login_email)) },
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
            )

            TextField(value = passwordTextFieldValue.value, onValueChange = { password ->
                passwordTextFieldValue.value = password
            }, placeholder = { Text(text = stringResource(id = R.string.login_password)) },
            modifier = Modifier
                .padding(bottom = 70.dp)
                .clip(shape = RoundedCornerShape(30.dp)),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                //register button
                Button(onClick = {
                    Log.i("Auth", "register begin")

                    firebaseAuth.createUserWithEmailAndPassword(
                        emailTextField.value.text, passwordTextFieldValue.value.text
                    )
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.i("Auth", "register complete!!")
                                pNavController.navigate("home")

                            } else if (task.isCanceled) {
                                Log.e("Auth", "What are you doing?!")
                            }
                        }.addOnFailureListener {
                            Log.e("Auth", "mission failed!")
                        }
                }, modifier = Modifier.padding(start=50.dp)) {
                    Text(text = stringResource(id = R.string.login_register_button))
                }
                //Login button
                Button(onClick = {

                    Log.i("Auth", "login begin")

                    firebaseAuth.signInWithEmailAndPassword(
                        emailTextField.value.text, passwordTextFieldValue.value.text
                    )
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.i("AUTH", "Login complete")
                                pNavController.navigate("home")

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(
                                    context,
                                    failedResource,
                                    Toast.LENGTH_LONG,
                                ).show()
                            }
                        }
                }, modifier = Modifier.padding(end=50.dp)) {
                    Text(text = stringResource(id = R.string.login_login_button))
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewLogin() {
    val navController = rememberNavController()
    Login(navController)
}
