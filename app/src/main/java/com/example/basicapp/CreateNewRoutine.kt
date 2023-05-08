package com.example.basicapp

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class CreateNewRoutine : AppCompatActivity() {

    lateinit var eventTv:TextView
    lateinit var actionTv:TextView
    lateinit var routineInput:TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_routine)

        eventTv = findViewById<TextView>(R.id.addedEventTv)
        actionTv = findViewById<TextView>(R.id.actionTv)
        routineInput = findViewById<TextInputEditText>(R.id.routineName)

        val extras = intent.extras
        if (extras != null) {
            val date = extras.getString("date")
            val action = extras.getString("text")
            val routineName = extras.getString("routineName")


            routineInput.setText(routineName)

            if (date != null) {
                if(date.startsWith("Date and")){
                    eventTv.text = "$date"
                }
                else{
                    eventTv.text = "Date and Time \n The dateTime is $date"
                }
            }

            eventTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_access_time_24, 0,R.drawable.baseline_settings_24,0)

            actionTv.text = "Notification \n Send Notification : $action"
            actionTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_message_24, 0,R.drawable.baseline_settings_24,0)
        }
    }

    fun AddEvent(view: View) {
        val intent = Intent(this, AddEvent::class.java)
        intent.putExtra("routineName", routineInput.text.toString())

        startActivity(intent)
    }

    fun AddAction(view: View) {
        val intent = Intent(this, CreateAction::class.java)
        intent.putExtra("routineName", routineInput.text.toString())
        intent.putExtra("date", eventTv.text)

        startActivity(intent)
    }

    fun Back(view: View) {
        finish()
    }

    fun SaveRoutine(view: View) {
        val preferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)

        val editor = preferences.edit()

        editor.putString("value", routineInput.text.toString())

        editor.apply()

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}