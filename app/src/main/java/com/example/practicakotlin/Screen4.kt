package com.example.practicakotlin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun Screen4(navController: NavController, secretNumber: Int) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Blue)) {
        Text(
            text = "Screen4 ${secretNumber}",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable
                { navController.navigate(Routes.Screen1.route) })
    }
}