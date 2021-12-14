package com.example.findmyage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvShowAge:TextView? = null
    private var etDOB:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGetAge = findViewById<Button>(R.id.btnShowMyAge)
        tvShowAge = findViewById(R.id.tvShowAge)
        etDOB = findViewById(R.id.etDOB)

        /*
        btnGetAge.setOnClickListener {
            btnGetAgeClick()
        }
        */
    }

    fun btnGetAgeClick()
    {
        val userDOB:Int = Integer.parseInt(etDOB?.text.toString())
        val currentYear:Int = Calendar.getInstance().get(Calendar.YEAR)
        val userAgeInYears:Int = currentYear-userDOB
        tvShowAge?.text = "Your Age is $userAgeInYears"
    }
}