package com.example.apppreguntas.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.apppreguntas.R
import com.example.apppreguntas.ui.rutas.Rutas

@Composable
fun PantallaHome(navController : NavHostController?){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp).background(colorResource(id = R.color.BackgroundDark))) {
        Text(
            modifier = Modifier,
            lineHeight = 40.sp,
            text = "¿Te atreves a jugar?",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            color = colorResource(id = R.color.white)
        )
        Button(onClick = { navController?.navigate(Rutas.PantallaCuestiones.ruta) },
            Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopCenter)
                .padding(15.dp),
            colors = ButtonDefaults.outlinedButtonColors(colorResource( R.color.ButtonDefect))) {
            Row(verticalAlignment = Alignment.Top){
                Text("Jugar")
                Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "")

            }
        }

    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHome(){
    PantallaHome(navController = null)
}