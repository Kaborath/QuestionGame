package com.example.questiongame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.questiongame.Constants.Partida.teamSize
import com.example.questiongame.databinding.ActivityCompetitiveOptionBinding

class CompetitiveOptionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityCompetitiveOptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompetitiveOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn2PlayerTeam.setOnClickListener(this)
        binding.btn3PlayerTeam.setOnClickListener(this)
    }
    // Aca elegimos si es que los equipos son de 2 o 3
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_2PlayerTeam->{
                val intent = Intent(this, TeamSetActivity::class.java)
                teamSize = 2
                startActivity(intent)
            }
            R.id.btn_3PlayerTeam->{
                val intent = Intent(this, TeamSetActivity::class.java)
                teamSize = 3
                startActivity(intent)
            }
        }
    }
}