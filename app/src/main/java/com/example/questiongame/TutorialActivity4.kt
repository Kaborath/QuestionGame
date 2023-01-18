package com.example.questiongame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.questiongame.databinding.ActivityTutorial4Binding

class TutorialActivity4 : AppCompatActivity() {
    lateinit var binding : ActivityTutorial4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTutorial4Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSiguiente4.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}