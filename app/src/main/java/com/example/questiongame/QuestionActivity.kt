package com.example.questiongame

import android.app.ActionBar
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.content.ContextCompat
import com.example.questiongame.Constants.Equipo_1.team1Avatar
import com.example.questiongame.Constants.Equipo_1.team1Name
import com.example.questiongame.Constants.Equipo_1.team1Points
import com.example.questiongame.Constants.Equipo_2.team2Avatar
import com.example.questiongame.Constants.Equipo_2.team2Name
import com.example.questiongame.Constants.Equipo_2.team2Points
import com.example.questiongame.Constants.Equipo_3.team3Avatar
import com.example.questiongame.Constants.Equipo_3.team3Name
import com.example.questiongame.Constants.Equipo_3.team3Points
import com.example.questiongame.Constants.GlobalVariable.PlayerDrawable
import com.example.questiongame.Constants.GlobalVariable.fechaDeNacimiento1
import com.example.questiongame.Constants.GlobalVariable.player1Name
import com.example.questiongame.Constants.GlobalVariable.playerPoints
import com.example.questiongame.Constants.GlobalVariable.timeline
import com.example.questiongame.Constants.Partida.answerType
import com.example.questiongame.Constants.Partida.matchQuestions
import com.example.questiongame.Constants.Partida.singlePlayer
import com.example.questiongame.Constants.Partida.turno
import com.example.questiongame.databinding.ActivityQuestionBinding
import com.google.android.material.button.MaterialButton

class QuestionActivity : AppCompatActivity(), View.OnClickListener{

    private var posicionActual: Int = timeline // Posicion actual del total de las preguntas
    private var listaPreguntas: ArrayList<Pregunta>? = null // Lista inicial vacia de preguntas
    private var posicionSeleccionada: Int = 0
    private var gamemode : Boolean = singlePlayer

    private lateinit var binding: ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)

        setPlayers(gamemode)

        setContentView(binding.root)

        listaPreguntas = matchQuestions

        setPreguntas()

        binding.btnOptionOne.setOnClickListener(this)
        binding.btnOptionTwo.setOnClickListener(this)
        binding.btnOptionThree.setOnClickListener(this)
        binding.btnOptionFour.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_OptionOne->{
                verificacion(binding.btnOptionOne, 1)
            }
            R.id.btn_OptionTwo->{
                verificacion(binding.btnOptionTwo, 2)
            }
            R.id.btn_OptionThree->{
                verificacion(binding.btnOptionThree, 3)
            }
            R.id.btn_OptionFour->{
                verificacion(binding.btnOptionFour,4)
            }
        }
    }
    fun setPreguntas(){
        // Pregunta actual va a ser igual a la pregunta en la posicion 0
        val pregunta = listaPreguntas!![posicionActual - 1]

        //Se setean los valores de "pregunta"
        binding.tvQuestionNumber.text = "Pregunta: " + posicionActual
        binding.tvPregunta.text = pregunta!!.encabezado
        binding.btnOptionOne.text = pregunta.opcionUno
        binding.btnOptionTwo.text = pregunta.opcionDos
        binding.btnOptionThree.text = pregunta.opcionTres
        binding.btnOptionFour.text = pregunta.opcionCuatro
    }

    // Esta funcion recibe el botón clickeado y la posicion que se seleccionó, para verificar posteriormente
    fun verificacion( btn: MaterialButton, numeroPosicionSeleccionada : Int){
        posicionSeleccionada = numeroPosicionSeleccionada
        // igualamos la pregunta a la pregunta actual.
        val pregunta = listaPreguntas!![posicionActual - 1]
        if(posicionSeleccionada == pregunta.respuestaCorrecta){
            // Aca se asignan los puntos acorde al turno, si es equipo 1, 2 o 3
            if ( gamemode ){
                playerPoints++
            }else{
                when(turno){
                    1->{
                        team1Points++
                    }
                    2->{
                        team2Points++
                    }
                    3->{
                        team3Points++
                    }
                }
            }
            getAnswer(true,btn,pregunta.respuestaCorrecta)
            answerType = true
            setTimer(true)
        }else{
            getAnswer(false,btn,pregunta.respuestaCorrecta)
            answerType = false
            setTimer(false)
        }
    }

    //Esta funcion sirve para pintar y cambiar tanto el titulo entero, como los colores de los botones cuando esta correcto o incorrecto
    fun getAnswer(flag:  Boolean, btn: MaterialButton, numero: Int){
        val buttons = ArrayList<MaterialButton>()
        buttons.add(0,binding.btnOptionOne)
        buttons.add(1,binding.btnOptionTwo)
        buttons.add(2,binding.btnOptionThree)
        buttons.add(3,binding.btnOptionFour)
        var gris = ColorStateList.valueOf(Color.GRAY)
        var verde = ColorStateList.valueOf(Color.GREEN)
        var rojo = ColorStateList.valueOf(Color.RED)
        var correcto = buttons.get(numero-1)
        if ( flag ){
            for ( button in buttons){
                if (button.id != btn.id){
                    button.backgroundTintList = gris
                }
            }
            binding.tvPregunta.setTextColor(verde)
            binding.tvPregunta.text = "¡Correcto!"
            binding.tvPregunta.setTextSize(TypedValue.COMPLEX_UNIT_SP, 60f)
            binding.tvPregunta.gravity = Gravity.CENTER_HORIZONTAL
            binding.tvQuestionNumber.visibility = View.GONE
        }else{
            for (button in buttons){
                if (correcto.id != button.id)
                    button.backgroundTintList = gris
            }
            binding.tvPregunta.setTextColor(rojo)
            binding.tvPregunta.text = "¡Incorrecto! La respuesta correcta es :"
            binding.tvPregunta.setTextSize(TypedValue.COMPLEX_UNIT_SP, 60f)
            binding.tvPregunta.gravity = Gravity.CENTER_HORIZONTAL
            binding.tvQuestionNumber.visibility = View.GONE
        }
    }

    // Funcion simple para pasar de una actividad a otra
    fun setTimer(flag: Boolean){
        val handler = Handler()
        if ( flag ){
            val runnable = Runnable {
                val intent = Intent(this, TimelineActivity::class.java)
                startActivity(intent)
            }
            handler.postDelayed(runnable, 2000)
        }else{
            val runnable = Runnable {
                val intent = Intent(this, TimelineActivity::class.java)
                startActivity(intent)
            }
            handler.postDelayed(runnable, 3500)
        }
    }

    // Setea los jugadores acorde a si es un juego single player o uno multi
    fun setPlayers( flag : Boolean){
        if (flag){
            binding.tvTeamPortraitName.text = player1Name
            binding.ivTeamPortrait.background = PlayerDrawable
        }else{
            when( turno ){
                1->{
                    binding.tvTeamPortraitName.text = "Equipo de " + team1Name
                    binding.ivTeamPortrait.background = team1Avatar
                }
                2->{
                    binding.tvTeamPortraitName.text = "Equipo de " + team2Name
                    binding.ivTeamPortrait.background = team2Avatar
                }
                3->{
                    binding.tvTeamPortraitName.text = "Equipo de " + team3Name
                    binding.ivTeamPortrait.background = team3Avatar
                }
            }
        }
    }
}