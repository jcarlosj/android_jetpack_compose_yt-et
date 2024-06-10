package dev.jcarlosj.simplejetpackcomposeapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf( "")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Login image",
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = "Welcome Back!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp) )
        Text(text = "Login to your account")
        Spacer(modifier = Modifier.height(12.dp) )
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(text = "Email address")
            }
        )
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(12.dp) )
        Button(onClick = {
            Log.i("Credential", "Email: $email, Password: $password")
        }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(32.dp) )
//        TextButton(onClick = { /*TODO*/ }) {
//            Text(text = "Forgot Password?")
//        }
        Text(text = "Forgot password!", modifier = Modifier.clickable {  })
        Spacer(modifier = Modifier.height(32.dp) )
        Text(text = "Or sign in with")

        Spacer(modifier = Modifier.height(32.dp) )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 85.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_facebook_48),
                contentDescription = "Facebook",
                modifier = Modifier
                    .size(55.dp)
                    .clickable { }
            )
            Image(
                painter = painterResource(id = R.drawable.icon_google_48),
                contentDescription = "Google",
                modifier = Modifier
                    .size(55.dp)
                    .clickable { }
            )
            Image(
                painter = painterResource(id = R.drawable.icon_twitter_48),
                contentDescription = "Twitter",
                modifier = Modifier
                    .size(55.dp)
                    .clickable { }
            )
        }
    }

}