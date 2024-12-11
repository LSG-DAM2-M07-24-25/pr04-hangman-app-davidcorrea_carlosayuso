package com.example.practicakotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacio.view.EntryPoint
import com.example.practicakotlin.View.Screen1
import com.example.practicakotlin.View.Screen2
import com.example.practicakotlin.View.Screen3
import com.example.practicakotlin.View.Screen4
import com.example.practicakotlin.ui.theme.PracticaKotlinTheme
import java.lang.reflect.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import com.example.practicakotlin.ModelView.PalabrasController

class MainActivity : ComponentActivity() {
    val palabrasController: PalabrasController by viewModels<PalabrasController>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaKotlinTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    EntryPoint(navigationController)
                }
            }
        }
    }
}


