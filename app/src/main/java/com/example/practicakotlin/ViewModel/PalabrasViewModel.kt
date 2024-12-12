package com.example.practicakotlin.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicakotlin.Model.Palabras
import kotlinx.coroutines.launch

class PalabrasViewModel : ViewModel() {
    private val _palabras = MutableLiveData<List<String>>(emptyList())
    val palabras: LiveData<List<String>> = _palabras

    fun cargarPalabras(tipoDificultad: String) {
        _palabras.value = when (tipoDificultad) {
            "Fácil" -> Palabras.faciles
            "Medio" -> Palabras.medianas
            "Difícil" -> Palabras.dificiles
            else -> emptyList()
        }
    }
}

