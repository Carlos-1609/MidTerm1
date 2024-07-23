package com.example.midterm

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.*


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        var btnCalc : Button = findViewById(R.id.btnCalc)
        val btnDone : Button = findViewById(R.id.btnDone)
        var editTextClass1 : EditText = findViewById(R.id.editTextClass1)
        var editTextClass2 : EditText = findViewById(R.id.editTextClass2)
        var editTextClass3 : EditText = findViewById(R.id.editTextClass3)
        var textViewGrade : TextView = findViewById(R.id.textViewGrade)
        val textViewMsg : TextView = findViewById(R.id.textViewMsg)
        val spinnerUnis : Spinner = findViewById(R.id.spinnerUnis)
        var grade = 0
        var flag = "Universities"
        val options = arrayOf("LakeHead","Harvard","MIT","UCLA", "Other")
        val name = intent.getStringExtra("EXTRA_NAME")
        spinnerUnis.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,options)
        spinnerUnis.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options[p2]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btnDone.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply {
            }
            startActivity(intent)
        }

        btnCalc.setOnClickListener{
            var grade1 = editTextClass1.text.toString().toInt()
            var grade2 = editTextClass2.text.toString().toInt()
            var grade3 = editTextClass3.text.toString().toInt()
            textViewMsg.text = "$name your grade at $flag is: "
            grade = (grade1 + grade2 + grade3)/3
            if(grade in 85..100){
                textViewGrade.setTextColor(Color.parseColor("#19ff57"))
                textViewGrade.text = "A"
            }else if(grade in 75..84 ){
                textViewGrade.setTextColor(Color.parseColor("#46c242"))
                textViewGrade.text = "B"
            }else if(grade in 65..74){
                textViewGrade.setTextColor(Color.parseColor("#d3e320"))
                textViewGrade.text = "C"
            }else if(grade in 50..64){
                textViewGrade.setTextColor(Color.parseColor("#e36b20"))
                textViewGrade.text = "D"
            }else{
                textViewGrade.setTextColor(Color.parseColor("#f20a0a"))
                textViewGrade.text = "F"


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}}