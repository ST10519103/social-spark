package com.example.socialspark

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
// Instead of individual imports i used * to import everything from android.widget
import android.widget.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Linking UI components
        val etInputTimeOfDay = findViewById<EditText>(R.id.etInputTimeOfDay)
        val btnEnter = findViewById<Button>(R.id.btnEnter)
        val tvSuggestion = findViewById<TextView>(R.id.tvSuggestion)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnEnter.setOnClickListener {
            val timeofday = etInputTimeOfDay.text.toString().trim().lowercase()

            val suggestion: String

            if (timeofday== "morning" ){
                suggestion= "go work out with friends"
            } else if (timeofday== "mid morning"){
                suggestion= "plan lunch with someone"
            } else if (timeofday== "afternoon"){
                suggestion= "get some important work done"
            } else if (timeofday== "evening"){
                suggestion= "spend time with family"
            } else if (timeofday== "night"){
                suggestion= "switch your phone off ,give youself 8 hours of sleep "
            } else {
                suggestion= "pick morning ,mid morning ,afternoon,evening or night"
            }
            tvSuggestion.text = suggestion
        }
        btnReset.setOnClickListener {
            etInputTimeOfDay?.text?.clear()
            tvSuggestion.text= "suggestion display"
        }
        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }

}