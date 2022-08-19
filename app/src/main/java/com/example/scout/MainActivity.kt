package com.example.scout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sign_up : TextView
        sign_up = findViewById(R.id.sign_up)
        sign_up .setOnClickListener(View.OnClickListener {
        val intent = Intent(this,Sign_up::class.java)
            startActivity(intent)
        })
    }
}