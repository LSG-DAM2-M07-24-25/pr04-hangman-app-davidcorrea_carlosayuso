package com.example.practicakotlin.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.practicakotlin.R
import com.example.practicakotlin.Routes

@Composable
fun Screen2(navController: NavController) {
    var selectedDificultad by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_colgado),
                contentDescription = "Logo",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Dificultad { dificultad ->
                selectedDificultad = dificultad
            }
            // Botón Play para avanzar a la siguiente pantalla
            Button(

                onClick = { 
                    navController.navigate(Routes.Pantalla3.createRoute(selectedDificultad))
                },
                enabled = selectedDificultad.isNotEmpty()
            ) {
                Text("Jugar")
            }
            Spacer(modifier = Modifier.size(30.dp)) // Botón Ayuda para mostrar reglas
            Button(
                onClick = {}
            ) {
                Text("Reglas")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewScreen2() {
   // Screen2()
}




@Composable
fun Dificultad(onDificultadSelected: (String) -> Unit) {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val dificultades = listOf("Fácil", "Medio", "Difícil")

    Column(
        Modifier.padding(20.dp, 80.dp)
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .background(Color.Black)
        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }, modifier = Modifier.background(Color.Black)) {
            dificultades.forEach { dificultad ->
                DropdownMenuItem(
                    text = { Text(text = dificultad, color = Color.White) },
                    onClick = {
                        expanded = false
                        selectedText = dificultad
                        onDificultadSelected(dificultad)
                    }
                )
            }
        }
    }
}
