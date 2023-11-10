package com.example.apppreguntas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Random
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Cuestionario() {

    var textoCabecera by remember { mutableStateOf("") }
    var textoRespuesta by remember { mutableStateOf("") }

    var colorBotonFalso by remember { mutableStateOf(R.color.ButtonDefect) }
    var colorBotonVerdadero by remember { mutableStateOf(R.color.ButtonDefect) }

    var actual by remember { mutableStateOf(0) }

    // lista preguntas
    var lista = ArrayList<Preguntas>()
    lista.add(
        Preguntas(
            "¿Es este el padre de todos?",
            R.drawable.mcqueen,
            true,
            "Correcto, como para que no",
            "Falso, deberías preguntar en casa"
        )
    )
    lista.add(
        Preguntas(
            "¿Este es tu padre?",
            R.drawable.chick_hicks,
            false,
            "No, tu padre el McQueen ¿recuerdas?",
            "Efectivamente rey"
        )
    )
    lista.add(
        Preguntas(
            "¿The King tiene una copa Piston?",
            R.drawable.the_king_43,
            true,
            "Efectivamente, es bicampeón",
            "Deberías aprender historia"
        )
    )
    lista.add(
        Preguntas(
            "¿Chick Hick tiene 300 calcomanías.?",
            R.drawable.the_king_43,
            false,
            "Que va, ponte a contar",
            "Muy bien, Chick Hick tiene 334  calcomanías"
        )
    )



    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.BackgroundDark))
            .padding(8.dp)
    ) {



//Cabecera Pregunta
        Text(
            modifier = Modifier
                .weight(2f)
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            lineHeight = 50.sp,
            text = if (actual == 0)
                lista.get(actual).pregunta
            else lista.get(actual).pregunta,

            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            color = colorResource(id = R.color.white)

        )



//Imagen
        Image(
            painter = painterResource(id = lista.get(actual).imagen),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(4f)
                .size(500.dp)
                .border(5.dp, colorResource(id = R.color.ButtonDefect))
                .align(Alignment.CenterHorizontally)
                .fillMaxSize()
        )



//Respuesta Pregunta
        Text(
            modifier = Modifier
                .weight(2f)
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            lineHeight = 50.sp,
            text = textoRespuesta,

            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            color = colorResource(id = R.color.TexGreen)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {


//Boton Verdadero
            TextButton(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
                    .fillMaxSize(),
                colors = ButtonDefaults.outlinedButtonColors(colorResource(id =  colorBotonVerdadero)),
                onClick = {
                    textoRespuesta = lista.get(actual).Rverdadero
                    if (lista.get(actual).respuesta){
                        colorBotonVerdadero = R.color.CorrectAnswer
                        colorBotonFalso = R.color.IncorrectAnswe
                    } else {
                        colorBotonVerdadero = R.color.IncorrectAnswe
                        colorBotonFalso = R.color.CorrectAnswer
                    }
                }

            ) {
                Text(
                    text = "Verdadero",
                    color = colorResource(id = R.color.black),
                    fontSize = 20.sp
                )
            }


//Boton Falso
            TextButton(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
                    .fillMaxSize(),
                onClick = {
                    textoRespuesta = lista.get(actual).RFalso
                    if (!lista.get(actual).respuesta){
                        colorBotonVerdadero = R.color.IncorrectAnswe
                        colorBotonFalso = R.color.CorrectAnswer
                    } else {
                        colorBotonVerdadero = R.color.CorrectAnswer
                        colorBotonFalso = R.color.IncorrectAnswe
                    }
                },
                colors = ButtonDefaults.outlinedButtonColors(colorResource(id = colorBotonFalso))
            ) {
                Text(
                    text = "Falso",
                    color = colorResource(id = R.color.black),
                    fontSize = 20.sp
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {

//Boton Anterior
            TextButton(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .weight(1f),
                onClick = {
                    if (actual == 0) {
                        actual = lista.lastIndex
                    } else {
                        actual--
                    }
                    colorBotonVerdadero = R.color.ButtonDefect
                    colorBotonFalso = R.color.ButtonDefect
                    textoRespuesta = ""
                },
                colors = ButtonDefaults.outlinedButtonColors(colorResource(id = R.color.ButtonDefect)),
            ) {
                Row() {
                    Text(
                        text = "",
                        color = colorResource(id = R.color.BackgroundYellow),
                        fontSize = 20.sp
                    )
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "flecha",
                        tint = colorResource(id = R.color.black)
                    )

                }
            }


//Boton Random
            TextButton(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .weight(1f),
                onClick = {
                    actual = Random().nextInt(lista.lastIndex + 1)

                    colorBotonVerdadero = R.color.ButtonDefect
                    colorBotonFalso = R.color.ButtonDefect
                    textoRespuesta = ""
                },
                colors = ButtonDefaults.outlinedButtonColors(colorResource(id = R.color.ButtonDefect)),
            ) {
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.dado),
                        contentDescription = "Dado",
                        tint = colorResource(id = R.color.black)
                    )
                    Text(
                        text = "",
                        color = colorResource(id = R.color.black),
                        fontSize = 20.sp
                    )
                }
            }


//Boton Siguiente
            TextButton(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .weight(1f),
                onClick = {
                    if (lista.lastIndex == actual) {
                        actual = 0
                    } else {
                        actual++
                    }
                    colorBotonVerdadero = R.color.ButtonDefect
                    colorBotonFalso = R.color.ButtonDefect
                    textoRespuesta = ""
                },
                colors = ButtonDefaults.outlinedButtonColors(colorResource(id = R.color.ButtonDefect)),
            ) {
                Row() {
                    Icon(
                        Icons.Filled.ArrowForward,
                        contentDescription = "flecha",
                        tint = colorResource(id = R.color.black)
                    )
                    Text(
                        text = "",
                        color = colorResource(id = R.color.black),
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}



