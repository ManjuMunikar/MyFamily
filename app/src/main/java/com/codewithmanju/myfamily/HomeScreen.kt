package com.codewithmanju.myfamily

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)


        var btn = findViewById<Button>(R.id.open)
        btn.setOnClickListener() {
            onScreen()

        }
    }

        fun onScreen(){
            val intent= Intent(this, GuardScreen::class.java)
            startActivity(intent)

        }

    }