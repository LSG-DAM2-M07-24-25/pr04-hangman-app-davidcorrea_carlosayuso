package com.example.practicakotlin

sealed class Routes(val route: String) {
    object Screen1:Routes("Screen1")
    object Screen2:Routes("Screen2")
    object Screen3:Routes("Screen3")
    object Screen4:Routes("Screen4/{secretNumber}"){
        fun createRoute(secretNumber:Int) = "Screen4/$secretNumber"
    }
}