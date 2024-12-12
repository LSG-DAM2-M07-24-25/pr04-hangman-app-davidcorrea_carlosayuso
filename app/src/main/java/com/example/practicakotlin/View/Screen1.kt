package com.example.practicakotlin.View

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practicakotlin.R
import com.example.practicakotlin.Routes
import kotlinx.coroutines.delay

@Composable
fun Screen1(navController: NavHostController) {
    val opacity = remember { androidx.compose.animation.core.Animatable(0f) }

    LaunchedEffect(Unit) {
        opacity.animateTo(
            targetValue = 1f,
            animationSpec =  tween(durationMillis = 3500)
        )

        delay(2000)

        navController.navigate(Routes.Pantalla2.route)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ){
        Box(
            modifier = Modifier
                .alpha(opacity.value)
                .align(Alignment.Center)
        ){
            Column {
                Image(
                    painter = painterResource(id = R.drawable.logo_colgado),
                    contentDescription = "el ahorcado"
                )
                Spacer(modifier = Modifier.size(30.dp))
                Text(
                    text = "El colgao",
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }

        }
    }
    }

