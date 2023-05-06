package com.example.slcraft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class UpdateCart : AppCompatActivity() {
    //var arrData = arrayOf(1, 2, 3 ,4 ,5)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_cart)

        //val spinnerAmount :Spinner = findViewById(R.id.spinnerAmount)

        //val arrAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,arrData)

        val countNumber: AutoCompleteTextView = findViewById(R.id.countNumber)

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

        var btnNext1 = findViewById<Button>(R.id.button3)
        btnNext1.setOnClickListener {
            val intent = Intent(this,AddToCart::class.java)
            startActivity(intent)
        }
    }

}