package com.example.slcraft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddToProduct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        var btnNext = findViewById<Button>(R.id.btn2)
        btnNext.setOnClickListener {
            val intent = Intent(this,UpdateProduct::class.java)
            startActivity(intent)
        }
    }
}