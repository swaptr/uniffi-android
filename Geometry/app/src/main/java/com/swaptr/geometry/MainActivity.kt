package com.swaptr.geometry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import uniffi.geometry.gradient

class MainActivity : AppCompatActivity() {
    lateinit var calculate: Button
    lateinit var pointOneX: EditText
    lateinit var pointOneY: EditText
    lateinit var pointTwoX: EditText
    lateinit var pointTwoY: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pointOneX = findViewById(R.id.etXPointOne)
        pointOneY = findViewById(R.id.etYPointOne)
        pointTwoX = findViewById(R.id.etXPointTwo)
        pointTwoY = findViewById(R.id.etYPointTwo)
        calculate = findViewById(R.id.buttonCalculate)

        calculate.setOnClickListener {
            var pointOne = uniffi.geometry.Point(pointOneX.text.toString().toDouble(), pointOneY.text.toString().toDouble())
            var pointTwo = uniffi.geometry.Point(pointTwoX.text.toString().toDouble(), pointTwoY.text.toString().toDouble())
            var line = uniffi.geometry.Line(pointOne, pointTwo)
            val toast = Toast.makeText(this, "Gradient = ${gradient(line)}", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}