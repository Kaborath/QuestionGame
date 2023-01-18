package com.example.questiongame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.questiongame.databinding.ActivityTutorial2Binding

class TutorialActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityTutorial2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorial2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSiguiente2.setOnClickListener{
            val intent = Intent(this, TutorialActivity3::class.java)
            startActivity(intent)
        }
    }
}