package com.example.apppreguntas.ui.rutas

sealed class Rutas(val ruta: String) {
    object PantallaInicio: Rutas("PantallaHome") ;
    object PantallaCuestiones: Rutas("Cuestionario") ;
}
