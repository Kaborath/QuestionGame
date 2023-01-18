package com.example.questiongame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.questiongame.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivSiguiente1.setOnClickListener{
            val intent = Intent(this, TutorialActivity2::class.java)
            startActivity(intent)
        }
    }
}