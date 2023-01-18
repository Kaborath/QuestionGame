package com.example.questiongame

import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.questiongame.Constants.Equipo_1.team1Avatar
import com.example.questiongame.Constants.Equipo_1.team1Name
import com.example.questiongame.Constants.Equipo_1.team1Points
import com.example.questiongame.Constants.Equipo_1.team1Pos
import com.example.questiongame.Constants.Equipo_2.team2Avatar
import com.example.questiongame.Constants.Equipo_2.team2Name
import com.example.questiongame.Constants.Equipo_2.team2Points
import com.example.questiongame.Constants.Equipo_2.team2Pos
import com.example.questiongame.Constants.Equipo_3.team3Avatar
import com.example.questiongame.Constants.Equipo_3.team3Name
import com.example.questiongame.Constants.Equipo_3.team3Points
import com.example.questiongame.Constants.Equipo_3.team3Pos
import com.example.questiongame.Constants.GlobalVariable.PlayerDrawable
import com.example.questiongame.Constants.GlobalVariable.player1Name
import com.example.questiongame.Constants.GlobalVariable.playerPoints
import com.example.questiongame.Constants.GlobalVariable.playerPos
import com.example.questiongame.Constants.GlobalVariable.timeline
import com.example.questiongame.Constants.Partida.answerType
import com.example.questiongame.Constants.Partida.matchWinner
import com.example.questiongame.Constants.Partida.singlePlayer
import com.example.questiongame.Constants.Partida.teamSize
import com.example.questiongame.Constants.Partida.turno
import com.example.questiongame.databinding.ActivityTimelineBinding
import kotlinx.android.synthetic.main.activity_timeline.*
import kotlinx.android.synthetic.main.activity_timeline.view.*

class TimelineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTimelineBinding
    private val gameMode = singlePlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimelineBinding.inflate(layoutInflater)
        setDetails(gameMode)
        // si la respuesta es correcta chequea que mueve, sino pasa sin hacer nada
        if ( answerType ){
            checkToMove()
        }else{
            changeView()
        }
        setContentView(binding.root)
    }

    // Esta funcion setea los detalles, como la posicion actual ( para moverla en la linea de tiempo si tiene o no puntos), la imagen y el texto.
    fun setDetails(gameMode: Boolean){
        if (gameMode){
            binding.LlTeam1.x = playerPos
            binding.ivTeam1Portrait.background = PlayerDrawable
            binding.tvTeam1Name.text = player1Name
            binding.ivTeam2Portrait.background = ColorDrawable(Color.TRANSPARENT)
            binding.ivTeam3Portrait.background = ColorDrawable(Color.TRANSPARENT)
        }else{
            if (teamSize == 2){
                binding.LlTeam1.x = team1Pos
                binding.ivTeam1Portrait.background = team1Avatar
                binding.tvTeam1Name.text = "Equipo de " +team1Name
                binding.LlTeam2.x = team2Pos
                binding.ivTeam2Portrait.background = team2Avatar
                binding.tvTeam2Name.text = "Equipo de " +team2Name
                binding.ivTeam3Portrait.background = ColorDrawable(Color.TRANSPARENT)
            } else if ( teamSize == 3){
                binding.LlTeam1.x = team1Pos
                binding.ivTeam1Portrait.background = team1Avatar
                binding.tvTeam1Name.text = "Equipo de " +team1Name
                binding.LlTeam2.x = team2Pos
                binding.ivTeam2Portrait.background = team2Avatar
                binding.tvTeam2Name.text = "Equipo de " +team2Name
                binding.LlTeam3.x = team3Pos
                binding.ivTeam3Portrait.background = team3Avatar
                binding.tvTeam3Name.text = "Equipo de " +team3Name
            }
        }
    }
    //Esta funcion determina que layout hay que mover y utiliza Change view para determinar a que pestaña se va
    fun checkToMove(){
        if (gameMode){
            moveLayout(playerPoints,0)
            changeView()
        }else{
            when( turno ){
                1->{
                    moveLayout(team1Points, 1)
                    changeView()
                }
                2->{
                    moveLayout(team2Points, 2)
                    changeView()
                }
                3->{
                    moveLayout(team3Points, 3)
                    changeView()
                }
            }
        }
    }

    // Esta funcion es bastante simple, según lo que se ingresa, se mueve una cantidad de pixeles a la derecha. Dependiendo si el respectivo equipo tuvo mas putnos o no
    fun moveLayout(points: Int, equipo : Int){
        if(gameMode){
            when( points ){
                1->{
                    playerPos+= 135f
                    binding.LlTeam1.x = playerPos
                }
                2->{
                    playerPos+= 120f
                    binding.LlTeam1.x = playerPos
                }
                3->{
                    playerPos+= 120f
                    binding.LlTeam1.x = playerPos
                }
                4->{
                    playerPos+= 120f
                    binding.LlTeam1.x = playerPos
                }
                5->{
                    playerPos+= 120f
                    binding.LlTeam1.x = playerPos
                }
                6->{
                    playerPos+= 120f
                    binding.LlTeam1.x = playerPos
                }
                7->{
                    playerPos+= 120f
                    binding.LlTeam1.x = playerPos
                }
                8->{
                    playerPos+= 120f
                    binding.LlTeam1.x = playerPos
                }
                9->{
                    playerPos+= 120f
                    binding.LlTeam1.x = playerPos
                }
                10->{
                    playerPos+= 120f
                    binding.LlTeam1.x = playerPos
                }
            }
        }else{
            when ( equipo ){
                1->{
                    when( points ){
                        1->{
                            team1Pos+= 135f
                            binding.LlTeam1.x = team1Pos
                        }
                        2->{
                            move(binding.LlTeam1,1)
                        }
                        3->{
                            move(binding.LlTeam1,1)
                        }
                        4->{
                            move(binding.LlTeam1,1)
                        }
                        5->{
                            move(binding.LlTeam1,1)
                        }
                        6->{
                            move(binding.LlTeam1,1)
                        }
                        7->{
                            move(binding.LlTeam1,1)
                        }
                        8->{
                            move(binding.LlTeam1,1)
                        }
                        9->{
                            move(binding.LlTeam1,1)
                        }
                        10->{
                            move(binding.LlTeam1,1)
                        }
                    }
                }
                2->{
                    when( points ){
                        1->{
                            team2Pos+= 135f
                            binding.LlTeam2.x = team2Pos
                        }
                        2->{
                            move(binding.LlTeam2,2)
                        }
                        3->{
                            move(binding.LlTeam2,2)
                        }
                        4->{
                            move(binding.LlTeam2,2)
                        }
                        5->{
                            move(binding.LlTeam2,2)
                        }
                        6->{
                            move(binding.LlTeam2,2)
                        }
                        7->{
                            move(binding.LlTeam2,2)
                        }
                        8->{
                            move(binding.LlTeam2,2)
                        }
                        9->{
                            move(binding.LlTeam2,2)
                        }
                        10->{
                            move(binding.LlTeam2,2)
                        }
                    }
                }
                3->{
                    when( points ){
                        1->{
                            team3Pos+= 135f
                            binding.LlTeam3.x = team3Pos
                        }
                        2->{
                            move(binding.LlTeam3,3)
                        }
                        3->{
                            move(binding.LlTeam3,3)
                        }
                        4->{
                            move(binding.LlTeam3,3)
                        }
                        5->{
                            move(binding.LlTeam3,3)
                        }
                        6->{
                            move(binding.LlTeam3,3)
                        }
                        7->{
                            move(binding.LlTeam3,3)
                        }
                        8->{
                            move(binding.LlTeam3,3)
                        }
                        9->{
                            move(binding.LlTeam3,3)
                        }
                        10->{
                            move(binding.LlTeam3,3)
                        }
                    }
                }
            }
        }
    }
    // La función acomoda el valor de turno dependiendo de que equipo es el que se mueve
    fun setTurno(){
        when (turno){
            1->{
                turno = 2
            }
            2->{
                if ( teamSize == 2){
                    turno = 1
                } else{
                    turno = 3
                }
            }
            3->{
                turno = 1
            }
        }
    }

    // esta funcion cambia de vista dependiendo de el tipo de juego
    fun changeView(){
        if ( gameMode ){
            if ( playerPoints < 9 ){
                timeline++
                val handler = Handler()
                val runnable = Runnable {
                    val intent = Intent(this, QuestionActivity::class.java)
                    startActivity(intent)
                }
                handler.postDelayed(runnable, 2000)
            }else{
                val handler = Handler()
                val runnable = Runnable {
                    val intent = Intent(this, ResultadoActivity::class.java)
                    startActivity(intent)
                }
                handler.postDelayed(runnable, 2000)
            }
        }else{
            checkPoints()
        }
    }

    // Esta funcion checkea los puntos de la partida y si es que uno de los equipos es ganador se guarda en la variable global
    fun checkPoints(){
        if ( team1Points == 9 || team2Points == 9 || team3Points == 9 ){
            if ( team1Points == 9){
                matchWinner = 1
            }else if ( team2Points == 9 ){
                matchWinner = 2
            }else if ( team3Points == 9 ){
                matchWinner = 3
            }
            val intent = Intent(this, ResultadoActivity::class.java)
            startActivity(intent)
            timeline = 1
        }else{
            timeline++
            setTurno()
            val handler = Handler()
            val runnable = Runnable {
                val intent = Intent(this, QuestionActivity::class.java)
                startActivity(intent)
            }
            handler.postDelayed(runnable, 2000)
        }
    }
    fun move(v: View, equipo: Int){
        when(equipo){
            1->{
                team1Pos += 120f
                v.x = team1Pos
            }
            2->{
                team2Pos += 120f
                v.x = team2Pos
            }
            3->{
                team3Pos += 120f
                v.x = team3Pos
            }
        }
    }
}