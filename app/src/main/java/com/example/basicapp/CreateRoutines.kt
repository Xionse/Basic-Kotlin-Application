package com.example.basicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class CreateRoutines : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_routines)

        val preferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)

        val value = preferences.getString("value", "")

        val layout = findViewById<LinearLayout>(R.id.layouts)

        val textView = TextView(this)

        textView.text = value

        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_message_24, 0,0,0)

        layout.addView(textView)
    }

    fun Back(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun RouteToOther(view: View) {
        val intent = Intent(this, CreateNewRoutine::class.java)
        startActivity(intent)
    }

    fun AddEvent(view: View) {}
}