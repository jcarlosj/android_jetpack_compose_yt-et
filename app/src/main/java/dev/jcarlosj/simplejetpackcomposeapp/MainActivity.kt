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
                composable( Routes.screenB + "/{name}" ) {
                    val name = it.arguments?.getString( "name" );       // Obtenemos el valor pasado por la ruta

                    ScreenB( "Juan", name?: "No name" )
                }
            }
        }
    }
}