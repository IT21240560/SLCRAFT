package com.example.slcraft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.slcraft.models.Calculate

class SelectToCart : AppCompatActivity() {
    lateinit var countNumber: Number
    lateinit var textView3: Number
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selectto_cart)
        val countNumber: AutoCompleteTextView = findViewById(R.id.countNumber)

        val textView3: TextView = findViewById(R.id.textView3)

        val listNumber = ArrayList<Int>()
        listNumber.add(1)
        listNumber.add(2)
        listNumber.add(3)
        listNumber.add(4)
        listNumber.add(5)
        listNumber.add(6)
        listNumber.add(7)
        listNumber.add(8)
        listNumber.add(9)
        listNumber.add(10)

        val numberAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, listNumber)

        countNumber.setAdapter(numberAdapter)
        countNumber.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show()
        }




        var btnNext = findViewById<Button>(R.id.button)
        btnNext.setOnClickListener {
            val intent = Intent(this,AddToCart::class.java)
            startActivity(intent)
        }

       /* var intent = Intent(this, AddToCart::class.java)
            intent.putExtra("", buttonClick())
            startActivity(intent)
            finish()*/






    }
    fun buttonClick(v:View){
        var ans= 0.0
        val calculate = Calculate(
            countNumber.toInt(),
            textView3.toDouble()
        )
        when(v.id){
            R.id.button->ans =calculate.multiply()
        }

        println(ans)

    }


}