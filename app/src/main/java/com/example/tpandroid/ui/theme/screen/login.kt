package com.example.tpandroid.ui.theme.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tpandroid.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(pNavController: NavController) {

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

        var loginFailed by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(Alignment.Center)
                .fillMaxHeight()
                .background(colorResource(id = R.color.background)),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            //title
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 90.dp)
                    .height(80.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo")

            //message if the login fail
            Row(modifier = Modifier.fillMaxWidth().height(30.dp),
                horizontalArrangement = Arrangement.Center){
                if(loginFailed){
                    Text(text = stringResource(id = R.string.login_failed),
                        color = Color.Red,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(horizontal = 10.dp))
                }
            }


            TextField(
                value = emailTextField.value, onValueChange = { email ->
                    emailTextField.value = email

                }, placeholder = { Text(text = stringResource(id = R.string.login_email)) },
                modifier = Modifier
                    .padding(bottom = 30.dp, top = 10.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
            )

            TextField(value = passwordTextFieldValue.value, onValueChange = { password ->
                passwordTextFieldValue.value = password
            }, placeholder = { Text(text = stringResource(id = R.string.login_password)) },
            modifier = Modifier
                .padding(bottom = 60.dp)
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

                    if(emailTextField.value.text != "" && passwordTextFieldValue.value.text != "") {
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
                    }
                    else{
                        loginFailed = true
                        Log.e("Auth","no email/password")
                    }
                }, modifier = Modifier.padding(start=50.dp)) {
                    Text(text = stringResource(id = R.string.login_register_button))
                }
                //Login button
                Button(onClick = {

                    Log.i("Auth", "login begin")
                    if(emailTextField.value.text != "" && passwordTextFieldValue.value.text != "") {
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
                                    loginFailed = true
                                }
                            }
                    }else{
                        loginFailed = true
                        Log.e("Auth","no email/password")
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
