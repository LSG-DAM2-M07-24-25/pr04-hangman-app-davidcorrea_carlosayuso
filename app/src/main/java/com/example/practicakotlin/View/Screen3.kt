package com.example.practicakotlin.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.practicakotlin.R
import com.example.practicakotlin.Routes
import com.example.practicakotlin.ViewModel.PalabrasViewModel

@Composable
fun Screen3(
    viewModel: PalabrasViewModel,
    navController: NavHostController,
    dificultad: String
)  {
    var intentos by remember { mutableStateOf(5) }
    var deshabilitarBotones by remember { mutableStateOf(setOf<Char>()) }
    var haGanado by remember { mutableStateOf(false) }

    if (intentos == 0){
        navController.navigate(Routes.Pantalla4.createRoute(intentos, haGanado, dificultad))
    }

    LaunchedEffect(dificultad) {
        viewModel.cargarPalabras(dificultad)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = when (intentos) {
                    5 -> R.drawable.colgado_1_sinfondo
                    4 -> R.drawable.colgado_2_sinfondo
                    3 -> R.drawable.colgado_3_sinfondo
                    2 -> R.drawable.colgado_4_sinfondo
                    1 -> R.drawable.colgado_5_sinfondo
                    0 -> R.drawable.colgado_6_sinfondo
                    else -> R.drawable.colgado_6_sinfondo // Imagen final si se agotan los intentos
                }
            ),
            contentDescription = "Estado del ahorcado",
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
        )

        fun clickLetras(letra: Char) {
            deshabilitarBotones += letra
            intentos--
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
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(a) {
                            top.linkTo(primeraLinea)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "A",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('B')
                    },
                    enabled = 'B' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(b) {
                            top.linkTo(primeraLinea)
                            start.linkTo(a.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "B",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('C')
                    },
                    enabled = 'C' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(c) {
                            top.linkTo(primeraLinea)
                            start.linkTo(b.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "C",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('D')
                    },
                    enabled = 'D' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(d) {
                            top.linkTo(primeraLinea)
                            start.linkTo(c.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "D",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('E')
                    },
                    enabled = 'E' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(e) {
                            top.linkTo(primeraLinea)
                            start.linkTo(d.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "E",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('F')
                    },
                    enabled = 'F' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(f) {
                            top.linkTo(primeraLinea)
                            start.linkTo(e.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text("F",
                        color = Color.Black
                    )
                }

                // Segunda línea de botones
                OutlinedButton(
                    onClick = {
                        clickLetras('G')
                    },
                    enabled = 'G' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(g) {
                            top.linkTo(segundaLinea) // Usamos la segunda línea aquí
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "G",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('H')
                    },
                    enabled = 'H' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(h) {
                            top.linkTo(segundaLinea) // Usamos la segunda línea aquí
                            start.linkTo(g.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "H",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('I')
                    },
                    enabled = 'I' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(i) {
                            top.linkTo(segundaLinea) // Usamos la segunda línea aquí
                            start.linkTo(h.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "I",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('J')
                    },
                    enabled = 'J' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(j) {
                            top.linkTo(segundaLinea) // Usamos la segunda línea aquí
                            start.linkTo(i.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "J",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('K')
                    },
                    enabled = 'K' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(k) {
                            top.linkTo(segundaLinea) // Usamos la segunda línea aquí
                            start.linkTo(j.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "K",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('L')
                    },
                    enabled = 'L' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(l) {
                            top.linkTo(segundaLinea) // Usamos la segunda línea aquí
                            start.linkTo(k.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text("L",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('M')
                    },
                    enabled = 'M' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(m) {
                            top.linkTo(terceraLinea)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "M",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('N')
                    },
                    enabled = 'N' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(n) {
                            top.linkTo(terceraLinea)
                            start.linkTo(m.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "N",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('Ñ')
                    },
                    enabled = 'Ñ' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(ñ) {
                            top.linkTo(terceraLinea)
                            start.linkTo(n.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "Ñ",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('O')
                    },
                    enabled = 'O' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(o) {
                            top.linkTo(terceraLinea)
                            start.linkTo(ñ.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "O",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('P')
                    },
                    enabled = 'P' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(p) {
                            top.linkTo(terceraLinea)
                            start.linkTo(o.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "P",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('Q')
                    },
                    enabled = 'Q' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(q) {
                            top.linkTo(terceraLinea)
                            start.linkTo(p.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text("Q",
                        color = Color.Black
                    )
                }

                // Segunda línea de botones
                OutlinedButton(
                    onClick = {
                        clickLetras('R')
                    },
                    enabled = 'R' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(r) {
                            top.linkTo(cuartaLinea) // Usamos la segunda línea aquí
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "R",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('S')
                    },
                    enabled = 'S' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(s) {
                            top.linkTo(cuartaLinea) // Usamos la segunda línea aquí
                            start.linkTo(r.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "S",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('T')
                    },
                    enabled = 'T' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(t) {
                            top.linkTo(cuartaLinea) // Usamos la segunda línea aquí
                            start.linkTo(s.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "T",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('U')
                    },
                    enabled = 'U' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(u) {
                            top.linkTo(cuartaLinea) // Usamos la segunda línea aquí
                            start.linkTo(t.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "U",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('V')
                    },
                    enabled = 'V' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(v) {
                            top.linkTo(cuartaLinea) // Usamos la segunda línea aquí
                            start.linkTo(u.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(text = "V",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('W')
                    },
                    enabled = 'W' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(w) {
                            top.linkTo(cuartaLinea) // Usamos la segunda línea aquí
                            start.linkTo(v.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text("W",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('X')
                    },
                    enabled = 'X' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(x) {
                            top.linkTo(quintaLinea) // Usamos la segunda línea aquí
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text("X",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('Y')
                    },
                    enabled = 'Y' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(y) {
                            top.linkTo(quintaLinea) // Usamos la segunda línea aquí
                            start.linkTo(x.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text("Y",
                        color = Color.Black
                    )
                }

                OutlinedButton(
                    onClick = {
                        clickLetras('Z')
                    },
                    enabled = 'Z' !in deshabilitarBotones,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .constrainAs(z) {
                            top.linkTo(quintaLinea) // Usamos la segunda línea aquí
                            start.linkTo(y.end)
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text("Z",
                        color = Color.Black
                    )
                }
            }
        }
        Text(
            text = "Intentos: $intentos",
            modifier = Modifier.padding(16.dp)
        )
    }
}
