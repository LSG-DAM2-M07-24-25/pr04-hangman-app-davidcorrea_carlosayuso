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
import com.example.practicakotlin.ViewModel.PalabrasViewModel

/**
 * Definim el composable NavHost que el cridarem des del Main
 * @param navigationController
 * @author RIS
 * @since 2024-11-20
 */
@Composable
fun EntryPoint(navigationController: NavHostController, palabrasViewModel: PalabrasViewModel) {
    NavHost(
        navController = navigationController,
        startDestination = Routes.Pantalla1.route
    ) {
        composable(Routes.Pantalla1.route) { Screen1(navigationController) }
        composable(Routes.Pantalla2.route) { Screen2(navigationController) }



        composable(
            Routes.Pantalla3.route,
            arguments = listOf(
                navArgument("dificultad") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            Screen3(
                viewModel = palabrasViewModel,
                navController = navigationController,
                dificultad = backStackEntry.arguments?.getString("dificultad").orEmpty()
            )
        }



        composable(
            Routes.Pantalla4.route,
            arguments = listOf(
                navArgument("intentos") { type = NavType.IntType },
                navArgument("haGanado") { type = NavType.BoolType },
                navArgument("dificultad") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            Screen4(
                navController = navigationController,
                intentos = backStackEntry.arguments?.getInt("intentos") ?: 0,
                haGanado = backStackEntry.arguments?.getBoolean("haGanado") ?: false,
                dificultad = backStackEntry.arguments?.getString("dificultad").orEmpty(),
                palabraSeleccionada = backStackEntry.arguments?.getString("palabra").orEmpty()

            )
        }
    }
}
