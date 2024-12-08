package com.example.practicakotlin.View

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController

@Composable
fun Screen3(navController: NavHostController, dificultad: String) {
    Box(
        modifier = Modifier.fillMaxSize(), // Hace que el contenedor ocupe toda la pantalla
        contentAlignment = Alignment.Center // Centra el contenido dentro del contenedor
    ) {
        ConstraintLayout {
            val primeraLinea = createGuidelineFromTop(0.2f) // Primera línea de botones
            val segundaLinea = createGuidelineFromTop(0.35f) // Mover la segunda línea más abajo
            val terceraLinea = createGuidelineFromTop(0.5f) // Primera línea de botones
            val cuartaLinea = createGuidelineFromTop(0.65f) // Primera línea de botones
            val quintaLinea = createGuidelineFromTop(0.8f) // Primera línea de botones
            val (a, b, c, d, e, f) = createRefs()
            val (g, h, i, j, k, l) = createRefs()
            val (m, n, ñ, o, p, q) = createRefs()
            val (r, s, t, u, v, w) = createRefs()
            val (x, y, z) = createRefs()

            OutlinedButton(
                onClick = { /* Acción para el botón rojo */ },
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
                onClick = { /* Acción para el botón amarillo */ },
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
                onClick = { /* Acción para el botón verde */ },
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
                onClick = { /* Acción para el botón cian */ },
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
                onClick = { /* Acción para el botón cian */ },
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
                onClick = { /* Acción para el botón magenta */ },
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
                onClick = { /* Acción para el botón rojo */ },
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
                onClick = { /* Acción para el botón amarillo */ },
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
                onClick = { /* Acción para el botón verde */ },
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
                onClick = { /* Acción para el botón cian */ },
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
                onClick = { /* Acción para el botón cian */ },
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
                onClick = { /* Acción para el botón magenta */ },
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
                onClick = { /* Acción para el botón rojo */ },
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
                onClick = { /* Acción para el botón amarillo */ },
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
                onClick = { /* Acción para el botón verde */ },
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
                onClick = { /* Acción para el botón cian */ },
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
                onClick = { /* Acción para el botón cian */ },
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
                onClick = { /* Acción para el botón magenta */ },
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
                onClick = { /* Acción para el botón rojo */ },
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
                onClick = { /* Acción para el botón amarillo */ },
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
                onClick = { /* Acción para el botón verde */ },
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
                onClick = { /* Acción para el botón cian */ },
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
                onClick = { /* Acción para el botón cian */ },
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
                onClick = { /* Acción para el botón magenta */ },
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
        }
    }
}
