package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnCalcApp : Button = findViewById(R.id.btnCalcApp)
        val btnGradesApp : Button = findViewById(R.id.btnGradesApp)
        val editTextName : EditText = findViewById(R.id.editTextName)


        btnCalcApp.setOnClickListener{
                val intent = Intent(this, ThirdActivity::class.java).apply {
                    putExtra("EXTRA_NAME", editTextName.text.toString())
        }
            startActivity(intent)
        }
        btnGradesApp.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME", editTextName.text.toString())
            }
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}
