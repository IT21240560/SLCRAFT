package com.example.slcraft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnNext = findViewById<Button>(R.id.button3)
        btnNext.setOnClickListener {
            val intent = Intent(this,SelectToCart::class.java)
            startActivity(intent)
        }
    }
}