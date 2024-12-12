package com.example.practicakotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.navegacio.view.EntryPoint
import com.example.practicakotlin.View.Screen3
import com.example.practicakotlin.ui.theme.PracticaKotlinTheme
import com.example.practicakotlin.ViewModel.*

class MainActivity : ComponentActivity() {

    val palabrasController: PalabrasViewModel by viewModels<PalabrasViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaKotlinTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    EntryPoint(navigationController, palabrasController)

                }
            }
        }
    }
}


