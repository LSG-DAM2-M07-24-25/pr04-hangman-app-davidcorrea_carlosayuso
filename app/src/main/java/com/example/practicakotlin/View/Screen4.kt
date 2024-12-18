package com.example.practicakotlin.View

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practicakotlin.Routes

@Composable
fun Screen4(navController: NavController, intentos:Int, dificultad:String, palabraSeleccionada:String) {
    var mensaje: String
    var info: String

    if (intentos == 0) {
        mensaje = "HAS PERDIDO"
    } else {
        mensaje = "¡FELICIDADES!"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ){
        Text(
            text = mensaje,
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(16.dp)
        )

        if (intentos == 0){
            Text(text = "La palabra era: " + palabraSeleccionada,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(16.dp))
        }

        if (intentos == 1){
            info = "Te ha sobrado " + intentos + " intento"
            Text(text = info,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(16.dp))
        }else if (intentos > 1){
            info = "Te han sobrado " + intentos + " intentos"
            Text(text = info,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(16.dp))
        }

        Spacer(modifier = Modifier.size(30.dp))

        Button(
            onClick = {
                navController.navigate(Routes.Pantalla3.createRoute(dificultad))
            },shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Jugar de nuevo", fontFamily = FontFamily.Serif)
        }

        Spacer(modifier = Modifier.size(30.dp))

        Button(
            onClick = {
                navController.navigate(Routes.Pantalla2.route)
            },shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Menú", fontFamily = FontFamily.Serif)
        }
    }

}