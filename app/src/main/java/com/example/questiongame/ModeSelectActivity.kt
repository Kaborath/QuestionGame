package com.example.questiongame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.questiongame.Constants.Partida.singlePlayer
import com.example.questiongame.databinding.ActivityModeSelectBinding

/*
*
* En esta funcion se selecciona entre el modo un jugador o multi jugador. Conste que cuando se selecciona una de las dos,
*  se activa un "flag" que determina si es single player o multi player
*
* */

class ModeSelectActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityModeSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModeSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnModeSingle.setOnClickListener(this)
        binding.btnModeCompetitive.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_ModeSingle->{
                val intent = Intent(this, AvatarPickActivity::class.java)
                singlePlayer = true
                startActivity(intent)
            }
            R.id.btn_ModeCompetitive->{
                val intent = Intent(this, CompetitiveOptionActivity::class.java)
                singlePlayer = false
                startActivity(intent)
            }
        }
    }


}