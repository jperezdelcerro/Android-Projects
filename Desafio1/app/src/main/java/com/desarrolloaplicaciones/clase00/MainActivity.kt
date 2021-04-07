package com.desarrolloaplicaciones.clase00

import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var txtCartel: TextView
    lateinit var buttonPlus: Button
    lateinit var buttonLess: Button
    var texto: String = "Hola Mundo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCartel   = findViewById(R.id.txtCartel)
        buttonPlus  = findViewById(R.id.buttonMore)
        buttonLess  = findViewById(R.id.buttonLess)

        txtCartel.text  = texto
        buttonPlus.text = "+"
        buttonLess.text = "-"

        buttonPlus.setOnClickListener{
            val size = txtCartel.textSize * 1.1f
            txtCartel.setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
        }

        buttonLess.setOnClickListener{
            val size = txtCartel.textSize * 0.9f
            txtCartel.setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
        }

    }
}