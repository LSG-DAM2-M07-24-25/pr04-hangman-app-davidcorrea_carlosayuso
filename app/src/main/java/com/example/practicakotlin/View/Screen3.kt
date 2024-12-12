package com.example.practicakotlin.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.practicakotlin.R
import com.example.practicakotlin.Routes
import com.example.practicakotlin.ViewModel.PalabrasViewModel
import kotlin.random.Random



@Composable
fun Screen3(
    viewModel: PalabrasViewModel,
    navController: NavHostController,
    dificultad: String
)  {
    var intentos by remember { mutableStateOf(5) }
    var deshabilitarBotones by remember { mutableStateOf(setOf<Char>()) }
    var haGanado by remember { mutableStateOf(false) }
    var palabraSeleccionada by remember { mutableStateOf("") }
    var palabraMostrada by remember { mutableStateOf("") }

    if (intentos == 0){
        navController.navigate(Routes.Pantalla4.createRoute(intentos, dificultad, palabraSeleccionada))
    }

    LaunchedEffect(dificultad) {
        viewModel.cargarPalabras(dificultad)
        val palabras = viewModel.palabras.value ?: emptyList()
        if (palabras.isNotEmpty()) {
            palabraSeleccionada = palabras[Random.nextInt(palabras.size)]
            palabraMostrada = "_ ".repeat(palabraSeleccionada.length).trim()
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = when (intentos) {
                    1 -> R.drawable.colgado_2_sinfondo
                    2 -> R.drawable.colgado_3_sinfondo
                    3 -> R.drawable.colgado_4_sinfondo
                    4 -> R.drawable.colgado_5_sinfondo
                    5 -> R.drawable.colgado_6_sinfondo
                    0 -> R.drawable.colgado_1_sinfondo
                    else -> R.drawable.colgado_1_sinfondo
                }
            ),
            contentDescription = "Estado del ahorcado",
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
        )

        // Mostrar palabra como guiones bajos
        Text(
            text = palabraMostrada,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(16.dp)
        )


        fun clickLetras(letra: Char) {
            deshabilitarBotones += letra
            if (letra in palabraSeleccionada) {
                val nuevaPalabraMostrada = palabraSeleccionada.map {
                    if (it in deshabilitarBotones) it else '_'
                }.joinToString(" ")

                palabraMostrada = nuevaPalabraMostrada

                if (!nuevaPalabraMostrada.contains('_')) {
                    haGanado = true
                    navController.navigate(Routes.Pantalla4.createRoute(intentos, dificultad, palabraSeleccionada))
                }
            } else {
                intentos--
            }
        }


        Box(

            modifier = Modifier.weight(1f),
            contentAlignment = Center
        ) {
            ConstraintLayout {
                val primeraLinea = createGuidelineFromTop(0.0f) // Primera línea de botones
                val segundaLinea = createGuidelineFromTop(0.25f) // Mover la segunda línea más abajo
                val terceraLinea = createGuidelineFromTop(0.5f) // Primera línea de botones
                val cuartaLinea = createGuidelineFromTop(0.75f) // Primera línea de botones
                val quintaLinea = createGuidelineFromTop(1.0f) // Primera línea de botones

                val (a, b, c, d, e, f) = createRefs()
                val (g, h, i, j, k, l) = createRefs()
                val (m, n, ñ, o, p, q) = createRefs()
                val (r, s, t, u, v, w) = createRefs()
                val (x, y, z) = createRefs()

                OutlinedButton(
                    onClick = {
                        clickLetras('A')
                    },
                    enabled = 'A' !in deshabilitarBotones,
                    border = if ('A' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(a) {
                            top.linkTo(primeraLinea)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('A' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "A",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('B')
                    },
                    enabled = 'B' !in deshabilitarBotones,
                    border = if ('B' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(b) {
                            top.linkTo(primeraLinea)
                            start.linkTo(a.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('B' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "B",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('C')
                    },
                    enabled = 'C' !in deshabilitarBotones,
                    border = if ('C' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(c) {
                            top.linkTo(primeraLinea)
                            start.linkTo(b.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('C' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "C",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('D')
                    },
                    enabled = 'D' !in deshabilitarBotones,
                    border = if ('D' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(d) {
                            top.linkTo(primeraLinea)
                            start.linkTo(c.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('D' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "D",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('E')
                    },
                    enabled = 'E' !in deshabilitarBotones,
                    border = if ('E' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(e) {
                            top.linkTo(primeraLinea)
                            start.linkTo(d.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('E' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "E",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('F')
                    },
                    enabled = 'F' !in deshabilitarBotones,
                    border = if ('F' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(f) {
                            top.linkTo(primeraLinea)
                            start.linkTo(e.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('F' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("F",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                // Segunda línea de botones
                OutlinedButton(
                    onClick = {
                        clickLetras('G')
                    },
                    enabled = 'G' !in deshabilitarBotones,
                    border = if ('G' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(g) {
                            top.linkTo(segundaLinea) // Usamos la segunda línea aquí
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('G' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "G",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('H')
                    },
                    enabled = 'H' !in deshabilitarBotones,
                    border = if ('H' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(h) {
                            top.linkTo(segundaLinea) // Usamos la segunda línea aquí
                            start.linkTo(g.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('H' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "H",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('I')
                    },
                    enabled = 'I' !in deshabilitarBotones,
                    border = if ('I' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(i) {
                            top.linkTo(segundaLinea) // Usamos la segunda línea aquí
                            start.linkTo(h.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('I' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "I",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('J')
                    },
                    enabled = 'J' !in deshabilitarBotones,
                    border = if ('J' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(j) {
                            top.linkTo(segundaLinea) // Usamos la segunda línea aquí
                            start.linkTo(i.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('J' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "J",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('K')
                    },
                    enabled = 'K' !in deshabilitarBotones,
                    border = if ('K' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(k) {
                            top.linkTo(segundaLinea) // Usamos la segunda línea aquí
                            start.linkTo(j.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('K' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "K",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('L')
                    },
                    enabled = 'L' !in deshabilitarBotones,
                    border = if ('L' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(l) {
                            top.linkTo(segundaLinea) // Usamos la segunda línea aquí
                            start.linkTo(k.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('L' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("L",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('M')
                    },
                    enabled = 'M' !in deshabilitarBotones,
                    border = if ('M' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(m) {
                            top.linkTo(terceraLinea)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('M' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "M",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('N')
                    },
                    enabled = 'N' !in deshabilitarBotones,
                    border = if ('N' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(n) {
                            top.linkTo(terceraLinea)
                            start.linkTo(m.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('N' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "N",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('Ñ')
                    },
                    enabled = 'Ñ' !in deshabilitarBotones,
                    border = if ('Ñ' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(ñ) {
                            top.linkTo(terceraLinea)
                            start.linkTo(n.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('Ñ' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "Ñ",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('O')
                    },
                    enabled = 'O' !in deshabilitarBotones,
                    border = if ('O' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(o) {
                            top.linkTo(terceraLinea)
                            start.linkTo(ñ.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('O' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "O",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('P')
                    },
                    enabled = 'P' !in deshabilitarBotones,
                    border = if ('P' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(p) {
                            top.linkTo(terceraLinea)
                            start.linkTo(o.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('P' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "P",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('Q')
                    },
                    enabled = 'Q' !in deshabilitarBotones,
                    border = if ('Q' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(q) {
                            top.linkTo(terceraLinea)
                            start.linkTo(p.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('Q' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("Q",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                // Segunda línea de botones
                OutlinedButton(
                    onClick = {
                        clickLetras('R')
                    },
                    enabled = 'R' !in deshabilitarBotones,
                    border = if ('R' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(r) {
                            top.linkTo(cuartaLinea) // Usamos la segunda línea aquí
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('R' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "R",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('S')
                    },
                    enabled = 'S' !in deshabilitarBotones,
                    border = if ('S' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(s) {
                            top.linkTo(cuartaLinea) // Usamos la segunda línea aquí
                            start.linkTo(r.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('S' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "S",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('T')
                    },
                    enabled = 'T' !in deshabilitarBotones,
                    border = if ('T' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(t) {
                            top.linkTo(cuartaLinea) // Usamos la segunda línea aquí
                            start.linkTo(s.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('T' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "T",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('U')
                    },
                    enabled = 'U' !in deshabilitarBotones,
                    border = if ('U' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(u) {
                            top.linkTo(cuartaLinea) // Usamos la segunda línea aquí
                            start.linkTo(t.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('U' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "U",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('V')
                    },
                    enabled = 'V' !in deshabilitarBotones,
                    border = if ('V' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(v) {
                            top.linkTo(cuartaLinea) // Usamos la segunda línea aquí
                            start.linkTo(u.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('V' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "V",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('W')
                    },
                    enabled = 'W' !in deshabilitarBotones,
                    border = if ('W' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(w) {
                            top.linkTo(cuartaLinea) // Usamos la segunda línea aquí
                            start.linkTo(v.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('W' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("W",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('X')
                    },
                    enabled = 'X' !in deshabilitarBotones,
                    border = if ('X' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(x) {
                            top.linkTo(quintaLinea)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('X' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("X",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('Y')
                    },
                    enabled = 'Y' !in deshabilitarBotones,
                    border = if ('Y' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(y) {
                            top.linkTo(quintaLinea) // Usamos la segunda línea aquí
                            start.linkTo(x.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('Y' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("Y",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('Z')
                    },
                    enabled = 'Z' !in deshabilitarBotones,
                    border = if ('Z' in deshabilitarBotones) BorderStroke(1.dp, Color.Red) else BorderStroke(0.dp, Color.Black),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(z) {
                            top.linkTo(quintaLinea) // Usamos la segunda línea aquí
                            start.linkTo(y.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if ('Z' in deshabilitarBotones) Color.Black else Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("Z",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }
            }
        }
        Text(
            text = "Intentos: $intentos",
            fontSize = 30.sp, // Ajusta el tamaño de fuente aquí
            fontWeight = FontWeight.Bold, // Opcional: haz que el texto sea más grueso
            fontFamily = FontFamily.Serif, // Cambia la fuente aquí (por ejemplo, Serif)
            modifier = Modifier.padding(16.dp)
        )

    }
}
