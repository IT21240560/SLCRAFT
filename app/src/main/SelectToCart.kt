package com.example.slcraft

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.slcraft.models.Calculate
import com.example.slcraft.models.ItemModel
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase



class SelectToCart : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var qty: EditText
    private lateinit var textView3: TextView
    private lateinit var button:Button
    private lateinit var  dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selectto_cart)
        textView= findViewById(R.id.textView)
        qty = findViewById(R.id.qty)
        textView3= findViewById(R.id.textView3)
        button= findViewById(R.id.button)

       dbRef = FirebaseDatabase.getInstance().getReference("Items")
        button.setOnClickListener {
            saveItemData()
        }

        /*val listNumber = ArrayList<Int>()
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

        qty.setAdapter(numberAdapter)
        qty.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show()
        }*/




        /*var btnNext = findViewById<Button>(R.id.button)
        btnNext.setOnClickListener {
            val intent = Intent(this,AddToCart::class.java)
            startActivity(intent)
        }*/

      /*var intent = Intent(this, AddToCart::class.java)
            intent.putExtra("", buttonClick())
            startActivity(intent)
            finish()*/

       /* button.setOnClickListener {
            val intent = Intent(this, AddToCart::class.java)
            startActivity(intent)
        }*/
    }

    private fun saveItemData(){
        val itemName = textView.text.toString()
        val itemQty = qty.text.toString()
        val itemUnitPrice = textView3.text.toString()


        if(itemName.isEmpty()){
            textView.error = "Please take name"
        }
        if(itemQty.isEmpty()){
            qty.error = "Please enter quantity"
        }

        if(itemUnitPrice.isEmpty()){
            textView3.error = "Please take unit price"
        }

        val itemId = dbRef.push().key!!


        val item = ItemModel(itemId, itemName,itemQty,itemUnitPrice)

        dbRef.child(itemId).setValue(item)
            .addOnCompleteListener {
                Toast.makeText( this, "Data inserted Successfully",Toast.LENGTH_LONG).show()

                qty.text.clear()

            }.addOnFailureListener {err ->
                Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()
            }



    }
    /*private fun buttonClick(v:View){
        var ans= 0.0
        val calculate = Calculate(
            qty.text.toString().toDouble(),
            textView3.text.toString().toDouble()
        )
        when(v.id){
            R.id.button->ans =calculate.multiply()
        }

        println(ans)

    }*/





}