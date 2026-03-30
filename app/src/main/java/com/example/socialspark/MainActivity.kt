package com.example.socialspark

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
// Instead of individual imports i used * to import everything from android.widget
import android.widget.*
import kotlin.math.log
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    //Tag used for logging in logcat
    private val  tag = "social spark"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // sets the layout for the activity
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
// Button click listener for generating suggestion
        btnEnter.setOnClickListener {
            val timeofday = etInputTimeOfDay.text.toString().trim().lowercase()
            Log.d(tag, "user input received: $timeofday")

            // Lists of suggestions for different times of day
            val morningSuggestions= listOf(
                "go work out with friends" ,
                "let start the morning of with a prayer" ,
                "share a funny meme with a friend"
            )
            val midMorningSuggestion= listOf(
                "plan lunch with someone",
                "send a voice note instead of texting",
                "check on your colleague"
            )
            val afternoonSuggestion= listOf(
                "get some important work done",
                "ask a deep question and start a random convo",
                "try a new cafe"
            )
            val eveningSuggestion= listOf(
                "spend time with family",
                "call someone you care about",
                "play a game with friends online"
            )
            val nightSuggestion = listOf(
                "switch your phone off ,give youself 8 hours of sleep ",
                "send a goodnight message",
                "end the day by spreading positivity"

            )
            // Variable to store the selected suggestion at random
            val suggestion: String

            if (timeofday== "morning" ){
                suggestion= morningSuggestions.random()
            } else if (timeofday== "mid morning"){
                suggestion= midMorningSuggestion.random()
            } else if (timeofday== "afternoon"){
                suggestion= afternoonSuggestion.random()
            } else if (timeofday== "evening"){
                suggestion= eveningSuggestion.random()
            } else if (timeofday== "night"){
                suggestion= nightSuggestion.random()
            } else {
                // Handle invalid input
                Log.w(tag,  "Invalid input entered")
                suggestion= "pick morning ,mid morning ,afternoon,evening or night"
            }
            Log.d(tag, "suggestion generated: $suggestion")
            tvSuggestion.text = suggestion
        }
        // Reset button clears input and resets suggestion text
        btnReset.setOnClickListener {
            etInputTimeOfDay?.text?.clear()
            tvSuggestion.text= "suggestion display"
        }
        // Exit button closes the app completely
        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }

}