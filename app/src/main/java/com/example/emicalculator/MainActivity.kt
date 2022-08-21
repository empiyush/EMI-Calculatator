package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.preference.PreferenceManager
import com.example.emicalculator.R

class EMICalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edTextNumber = findViewById<View>(R.id.edTextNumber) as EditText
        val edLoanAmount = findViewById<View>(R.id.edLoanAmount) as EditText
        val edROI = findViewById<View>(R.id.edROI) as EditText
        val btnEMI = findViewById<View>(R.id.btnEMI) as Button
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        btnEMI.setOnClickListener {
            val intTextNumber = edTextNumber.text.toString().toInt()
            val intLoanAmount = edLoanAmount.text.toString().toInt()
            val decROI = edROI.text.toString().toInt().toFloat()
            val editor = sharedPreferences.edit()
            editor.putInt("keyTextNumber", intTextNumber)
            editor.putInt("keyLoanAmount", intLoanAmount)
            editor.putFloat("keyROI", decROI)
            editor.commit()
            startActivity(Intent(this@EMICalculator, Window2::class.java))

        }
    }
}
//  startActivity(Intent(this@LoanCalculator, Payment::class.java))