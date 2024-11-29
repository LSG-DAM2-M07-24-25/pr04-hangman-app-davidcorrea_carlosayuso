package com.example.practicakotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicakotlin.View.Screen1
import com.example.practicakotlin.View.Screen2
import com.example.practicakotlin.View.Screen3
import com.example.practicakotlin.View.Screen4
import com.example.practicakotlin.ui.theme.PracticaKotlinTheme

class MainActivity : ComponentActivity() {
    //val numeroViewModel: NumeroViewModel by viewModels<NumeroViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaKotlinTheme {
                NavigationGraph()
            }
        }
    }
}

@Composable
fun NavigationGraph() {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Routes.Screen1.route
    ) {
        composable(Routes.Screen1.route) { Screen1(navigationController) }
        composable(Routes.Screen2.route) { Screen2(navigationController) }
        composable(Routes.Screen3.route) { Screen3(navigationController) }
        composable(
            Routes.Screen4.route,
            arguments = listOf(navArgument("secretNumber") { type = NavType.IntType })
        ) { backStackEntry ->
            Screen4(
                navigationController,
                backStackEntry.arguments?.getInt("secretNumber") ?: 0
            )
        }
    }
}
