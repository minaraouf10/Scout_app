package com.example.scout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    val colors = arrayOf("red","green","black","wight")
    lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        spinner = findViewById(R.id.spinner)

        val arrayAdapter =ArrayAdapter(this@MainActivity2,android.R.layout.simple_spinner_dropdown_item,colors)
        spinner.adapter =arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity2,"your select "+colors[p2],Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}




/*
        spinner = findViewById(R.id.spinner)

        val arrayAdapter =ArrayAdapter(this@Sign_up,android.R.layout.simple_spinner_dropdown_item,colors)
        spinner.adapter =arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@Sign_up,"your select "+level[p2],Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
 */