package dev.jcarlosj.simplejetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Routes.screenA ) {
                composable( Routes.screenA ) {
                    ScreenA( navController )
                }
                composable( Routes.screenB ) {
                    ScreenB()
                }
            }
        }
    }
}