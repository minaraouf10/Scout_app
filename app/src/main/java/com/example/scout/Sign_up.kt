package com.example.scout

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.String.format
import java.text.SimpleDateFormat
import java.util.*

abstract class Sign_up : AppCompatActivity() {
    val level = arrayOf("Primary one","Primary two","Primary three","Primary four","Primary five","Primary six")
    private  lateinit var date_ed : EditText
    private  lateinit   var date_tx : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        fun spinner_open() {
            val arrayAdapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, level)
            val level_school_spinner: Spinner
            level_school_spinner = findViewById(R.id.spinner_school)
            level_school_spinner.adapter = arrayAdapter
            level_school_spinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        Toast.makeText(this@Sign_up, "You select " + level[p2], Toast.LENGTH_LONG)
                            .show()
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }

        }


            date_ed = findViewById(R.id.date_ed)
            date_tx = findViewById(R.id.date_tx)

            val canlendar = Calendar.getInstance()

            val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                canlendar.set(Calendar.YEAR, year)
                canlendar.set(Calendar.MONTH, month)
                canlendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                updateLable(canlendar)
            }
            date_tx.setOnClickListener {
                DatePickerDialog(
                    this,
                    datePicker,
                    canlendar.get(Calendar.YEAR),
                    canlendar.get(Calendar.MONTH),
                    canlendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

    }
    private fun updateLable(calendar: Calendar){
        val myformat ="dd-MM-yyyy"
        val sdf = SimpleDateFormat(myformat,Locale.UK)
        date_ed.setText(sdf.format(calendar.time))
    }
}