package com.example.scout

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.scout.databinding.ActivitySignUpBinding
import java.text.SimpleDateFormat
import java.util.*

class SignUpActivity : AppCompatActivity() {


    lateinit var binding: ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val level = arrayOf(
            "Primary one",
            "Primary two",
            "Primary three",
            "Primary four",
            "Primary five",
            "Primary six"
        )


        setupAdapter();


        binding.button.setOnClickListener {
            Toast.makeText(this@SignUpActivity, "your select "/* + colors[p2]*/, Toast.LENGTH_LONG)
                .show()
        }
        val canlendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            canlendar.set(Calendar.YEAR, year)
            canlendar.set(Calendar.MONTH, month)
            canlendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            updateLable(canlendar)
        }
        binding.dateEd.setOnClickListener {
            DatePickerDialog(
                this,
                datePicker,
                canlendar.get(Calendar.YEAR),
                canlendar.get(Calendar.MONTH),
                canlendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

    }

    fun setupAdapter() {
        val colors = arrayOf("red", "green", "black", "wight")
        val arrayAdapter =
            ArrayAdapter(this@SignUpActivity, android.R.layout.simple_spinner_dropdown_item, colors)



        binding.spinnerSchool.adapter = arrayAdapter
        binding.spinnerSchool.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    Toast.makeText(
                        this@SignUpActivity,
                        "your select " + colors[p2],
                        Toast.LENGTH_LONG
                    )
                        .show()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }


    }

    private fun updateLable(calendar: Calendar) {
        val myformat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myformat, Locale.UK)
        binding.dateEd.setText(sdf.format(calendar.time))
    }
}