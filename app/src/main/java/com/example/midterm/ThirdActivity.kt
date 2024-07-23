package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)
        val editTextNum1 : EditText = findViewById(R.id.editTextNum1)
        val editTextNum2 : EditText = findViewById(R.id.editTextNum2)
        val textViewRes : TextView = findViewById(R.id.textViewRes)
        val textViewDispName : TextView = findViewById(R.id.textViewDispName)
        val btnDone2 : Button = findViewById(R.id.btnDone2)
        val btnAdd : Button = findViewById(R.id.btnAdd)
        val btnSub: Button = findViewById(R.id.btnSub)
        val btnMulti: Button = findViewById(R.id.btnMulti)
        val btnDiv: Button = findViewById(R.id.btnDiv)
        var flag = ""
        var num1 = 0
        var num2  = 0
        val name = intent.getStringExtra("EXTRA_NAME")
        btnDone2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply {
            }
            startActivity(intent)
        }

        btnAdd.setOnClickListener{
            num1 = editTextNum1.text.toString().toInt()
            num2 = editTextNum2.text.toString().toInt()
            flag = "add"
            textViewDispName.text = "$name your addition result is: "
            textViewRes.text = add(num1, num2).toString()
        }
        btnSub.setOnClickListener{
            num1 = editTextNum1.text.toString().toInt()
            num2 = editTextNum2.text.toString().toInt()
            flag = "sub"
            textViewDispName.text = "$name your subtraction result is: "
            textViewRes.text = sub(num1, num2).toString()
        }
        btnMulti.setOnClickListener{
            num1 = editTextNum1.text.toString().toInt()
            num2 = editTextNum2.text.toString().toInt()
            flag = "Multi"
            textViewDispName.text = "$name your multiplication result is: "
            textViewRes.text = multi(num1, num2).toString()
        }
        btnDiv.setOnClickListener{
            num1 = editTextNum1.text.toString().toInt()
            num2 = editTextNum2.text.toString().toInt()
            flag = "div"
            textViewDispName.text = "$name your division result is: "
            textViewRes.text = div(num1, num2).toString()
        }

        when(flag){
            "add" -> textViewRes.text = add(num1, num2).toString()
            "sub" -> textViewRes.text = sub(num1, num2).toString()
            "Multi" -> textViewRes.text = multi(num1, num2).toString()
            "div" -> textViewRes.text = div(num1, num2).toString()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun add(num1: Int, num2: Int): Int {
        return num1 + num2
    }
    private fun sub(num1: Int, num2: Int): Int {
        return num1 - num2
    }
    private fun multi(num1: Int, num2: Int): Int {
        return num1 * num2
    }
    private fun div(num1: Int, num2: Int): Int {
        return num1 / num2
    }
}

