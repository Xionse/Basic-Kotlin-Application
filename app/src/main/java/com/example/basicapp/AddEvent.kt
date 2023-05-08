package com.example.basicapp

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.util.Calendar

class AddEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)
    }

    fun SelectTime(view: View) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this,{ view, hourOfDay, minute -> onTimeSet(hourOfDay, minute) }, hour, minute, false)
        timePickerDialog.show()
    }

    fun onTimeSet(hourOfDay: Int, minute: Int)
    {
        val extras = intent.extras
        val intent = Intent(this, CreateNewRoutine::class.java)

        if (extras != null) {
            val routineName = extras.getString("routineName")

            intent.putExtra("routineName", routineName)
        }

        val currentTime = "$hourOfDay : $minute"
        intent.putExtra("date", currentTime)
        startActivity(intent)

    }

    fun Back(view: View) {
        finish()
    }
}