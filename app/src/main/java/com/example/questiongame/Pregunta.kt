package com.example.questiongame

data class Pregunta (
    val id : Int,
    val encabezado : String,
    val opcionUno : String,
    val opcionDos : String,
    val opcionTres : String,
    val opcionCuatro : String,
    val respuestaCorrecta : Int,
)