package com.example.apppreguntas.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apppreguntas.Cuestionario
import com.example.apppreguntas.ui.home.PantallaHome
import com.example.apppreguntas.ui.rutas.Rutas

@Composable
fun GrafoNavegacion(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Rutas.PantallaInicio.ruta ){
        composable(Rutas.PantallaInicio.ruta){
            PantallaHome(navController = navController)
        }
        composable(Rutas.PantallaCuestiones.ruta){
            Cuestionario()
        }
    }
}