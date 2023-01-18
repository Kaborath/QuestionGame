package com.example.questiongame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.questiongame.Constants.Equipo_1.team1Players
import com.example.questiongame.Constants.Equipo_2.team2Players
import com.example.questiongame.Constants.Equipo_3.team3Players
import com.example.questiongame.Constants.Partida.teamSize
import com.example.questiongame.databinding.ActivityTeamSetBinding
import kotlinx.android.synthetic.main.activity_team_set.*

class TeamSetActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityTeamSetBinding
    private var cantidadDeEquipos = teamSize
    private var times : Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamSetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1Player.setOnClickListener(this)
        binding.btn2Players.setOnClickListener(this)
        binding.btn3Players.setOnClickListener(this)

    }

    // Esta función lo que hace es, dependiendo de "times", la cual es una variable que sirve para saber en que numero de seleccion estamos, esto quiere decir
    // que cuando es 1, esta tocando la vista por primera vez y 2 cuando es la segunda, lo mismo con 3.
    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_1Player->{
                when (times){
                    // Si es que tocan el boton 1 en la primera iteración, hace que los jugadores del equipo 1 sean 1. Lo mismo pasa en los botones de mas abajo.
                    1->{
                        team1Players = 1
                        times++
                        binding.tvPlayersPerTeam.text = "$times"
                    }
                    2->{
                        // Este caso tiene un condicional, en caso de que los equipos sean de 2 para que automaticamente pase a la siguiente iteracióon
                        team2Players = 1
                        if (cantidadDeEquipos == 2){
                            val intent = Intent(this, AvatarPickActivity::class.java)
                            startActivity(intent)
                        } else {
                            times++
                            binding.tvPlayersPerTeam.text = "$times"
                        }
                    }
                    3->{
                        // cuando se llega a la tercera iteración, se pasa a la siguiente actividad
                        team3Players = 1
                        val intent = Intent(this, AvatarPickActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
            R.id.btn_2Players->{
                when (times){
                    1->{
                        team1Players = 2
                        times++
                        binding.tvPlayersPerTeam.text = "$times"
                    }
                    2->{
                        team2Players = 2
                        if (cantidadDeEquipos == 2){
                            val intent = Intent(this, AvatarPickActivity::class.java)
                            startActivity(intent)
                        } else {
                            times++
                            binding.tvPlayersPerTeam.text = "$times"
                        }
                    }
                    3->{
                        team3Players = 2
                        val intent = Intent(this, AvatarPickActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
            R.id.btn_3Players->{
                when (times){
                    1->{
                        team1Players = 3
                        times++
                        binding.tvPlayersPerTeam.text = "$times"
                    }
                    2->{
                        team2Players = 3
                        if (cantidadDeEquipos == 2){
                            val intent = Intent(this, AvatarPickActivity::class.java)
                            startActivity(intent)
                        } else {
                            times++
                            binding.tvPlayersPerTeam.text = "$times"
                        }
                    }
                    3->{
                        team3Players = 3
                        val intent = Intent(this, AvatarPickActivity::class.java)
                        startActivity(intent)

                    }
                }
            }
        }
    }
}