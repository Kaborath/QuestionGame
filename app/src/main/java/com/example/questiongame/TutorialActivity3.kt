package com.example.questiongame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.questiongame.databinding.ActivityTutorial3Binding

class TutorialActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityTutorial3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTutorial3Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSiguiente3.setOnClickListener{
            val intent = Intent(this, TutorialActivity4::class.java)
            startActivity(intent)
        }
    }
}