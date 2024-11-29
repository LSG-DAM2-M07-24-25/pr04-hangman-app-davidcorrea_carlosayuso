package com.example.navegacio.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.practicakotlin.Routes
import com.example.practicakotlin.View.Screen1
import com.example.practicakotlin.View.Screen2
import com.example.practicakotlin.View.Screen3
import com.example.practicakotlin.View.Screen4

/**
 * Definim el composable NavHost que el cridarem des del Main
 * @param navigationController
 * @author RIS
 * @since 2024-11-20
 */
@Composable
fun EntryPoint(navigationController: NavController) {
    // Definim el component NavHost per a establir les rutes entre pantalles
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.Pantalla1.route
    ) {

        // Establim que la ruta Pantalla1 ens dirigeix cap a la vista composable Screen1
        composable(Routes.Pantalla1.route) { Screen1(navigationController) }
        composable(Routes.Pantalla2.route) { Screen2(navigationController) }

        // Establim que la ruta Pantalla2 ens dirigeix cap a la vista composable Screen2
        composable(
            Routes.Pantalla3.route,
            arguments = listOf(
                navArgument("dificultad") { type = NavType.StringType })
        ) { backStackEntry ->
            Screen3(
                navigationController,
                backStackEntry.arguments?.getString("dificultad").orEmpty()
            )
        }

        // Establim que la ruta Pantalla3 ens dirigeix cap a la vista composable Screen3
        composable(
            Routes.Pantalla4.route,
            arguments = listOf(
                navArgument("intentos") { type = NavType.IntType },
                navArgument("haGanado") { type = NavType.BoolType }
                )
        ) { backStackEntry ->
            Screen4(
                navigationController,
                backStackEntry.arguments?.getInt("intentos") ?: 0,
                backStackEntry.arguments?.getBoolean("haGanado") ?: false
            )
        }
    }
}
