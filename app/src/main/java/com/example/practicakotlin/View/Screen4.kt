package com.example.practicakotlin.View

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.practicakotlin.Routes

@Composable
fun Screen4(navController: NavController, intentos:Int, haGanado:Boolean, dificultad:String) {
    var mensaje: String
    var info: String

    if (intentos == 0) {
        mensaje = "HAS PERDIDO "
    } else {
        mensaje = "FELICIDADES"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ){
        Text(text = mensaje)

        if (intentos > 0){
            info = "Te ha tomado " + intentos + " intentos"
            Text(text = info)
        }

        Button(
            onClick = {
                navController.navigate(Routes.Pantalla3.createRoute(dificultad))
            }
        ) {
            Text(text = "Volver a intentar")
        }

        Button(
            onClick = {
                navController.navigate(Routes.Pantalla2.route)
            }
        ) {
            Text(text = "Menu")
        }
    }

}