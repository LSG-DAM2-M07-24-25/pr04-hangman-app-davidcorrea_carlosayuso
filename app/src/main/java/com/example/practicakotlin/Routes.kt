package com.example.practicakotlin

sealed class Routes(val route: String) {
    object Pantalla1 : Routes("pantalla1")
    object Pantalla2 : Routes("pantalla2")
    object Pantalla3 : Routes("pantalla3/{dificultad}") {
        fun createRoute(dificultad: String) = "pantalla3/$dificultad"
    }
    object Pantalla4 : Routes("pantalla4/{intentos}/{haGanado}/{dificultad}/{palabra}") {
        fun createRoute(intentos: Int, haGanado: Boolean, dificultad: String, palabra: String) = "pantalla4/$intentos/$haGanado/$dificultad/$palabra"
    }
}