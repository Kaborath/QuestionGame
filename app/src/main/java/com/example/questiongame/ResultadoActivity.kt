package com.example.questiongame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.questiongame.Constants.Equipo_1.team1Avatar
import com.example.questiongame.Constants.Equipo_1.team1Name
import com.example.questiongame.Constants.Equipo_2.team2Avatar
import com.example.questiongame.Constants.Equipo_2.team2Name
import com.example.questiongame.Constants.Equipo_3.team3Avatar
import com.example.questiongame.Constants.Equipo_3.team3Name
import com.example.questiongame.Constants.GlobalVariable.PlayerDrawable
import com.example.questiongame.Constants.GlobalVariable.player1Name
import com.example.questiongame.Constants.Partida.matchWinner
import com.example.questiongame.Constants.Partida.singlePlayer
import com.example.questiongame.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityResultadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setWinner(matchWinner)
    }

    // Simple seteo de el ganador
    fun setWinner(winner : Int){
        if( singlePlayer){
            binding.ivWinner.background = PlayerDrawable
            binding.tvWinner.text = player1Name
            val handler = Handler()
            val runnable = Runnable {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            handler.postDelayed(runnable, 5000)
        }else{
            when ( winner ){
                1->{
                    binding.ivWinner.background = team1Avatar
                    binding.tvWinner.text = "Equipo de " +team1Name
                }
                2->{
                    binding.ivWinner.background = team2Avatar
                    binding.tvWinner.text = "Equipo de " + team2Name
                }
                3->{
                    binding.ivWinner.background = team3Avatar
                    binding.tvWinner.text = "Equipo de " + team3Name
                }
            }
            val handler = Handler()
            val runnable = Runnable {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            handler.postDelayed(runnable, 5000)
        }
    }
}