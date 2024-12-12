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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.practicakotlin.R
import com.example.practicakotlin.Routes

@Composable
fun Screen2(navController: NavController) {
    var selectedDificultad by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
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
                },shape = RoundedCornerShape(8.dp),
                enabled = selectedDificultad.isNotEmpty(),
                modifier = Modifier
                    .padding(16.dp)
                    .height(50.dp)
                    .width(180.dp)
            ) {

                Text(
                    text = "Jugar",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif

                )

            }

            Spacer(modifier = Modifier.size(30.dp))

            Button(
                onClick = { showDialog = true },shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .height(40.dp)
                    .width(140.dp)
            ) {

                Text(
                    text = "Reglas",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif
                )

            }

            if (showDialog) {
                AlertReglas(
                    onDismissRequest = {showDialog = false},
                    onConfirmation = { showDialog = false }
                )

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
        Modifier.padding(20.dp, 50.dp)
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            textStyle = TextStyle(color = Color.Black),
            placeholder = {Text(text = "Pulsa para seleccionar", fontFamily = FontFamily.Serif)},
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Green,
                disabledTextColor = Color.DarkGray,
                cursorColor = Color.Yellow ),
            modifier = Modifier
                .clickable { expanded = true }

        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color.LightGray)
        ) {
            dificultades.forEach { dificultad ->
                DropdownMenuItem(
                    text = { Text(text = dificultad, color = Color.Black, fontFamily = FontFamily.Serif) },
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

@Composable
fun AlertReglas(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit
) {
    val reglasDelJuego = "\n1. Selecciona la dificultad.\n2. Completa la palabra antes de que el muñeco sea linchado.\n3.Tienes 5 intentos"
    val icono = painterResource(id = R.drawable.book_svgrepo_com)

    AlertDialog(
        icon = {
            Icon(icono, contentDescription = "icono reglas", modifier = Modifier.size(40.dp))
        },
        title = {
            Text(text = "Reglas del Juego", fontFamily = FontFamily.Serif)
        },
        text = {
            Text(text = reglasDelJuego, fontFamily = FontFamily.Serif)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Dale", fontFamily = FontFamily.Serif)
            }

        }
    )
}
