package com.example.myapplication

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.example.emicalculator.R
import java.text.DecimalFormat

class Window2 : AppCompatActivity() {
    // 2nd page code
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        val tv3 = findViewById<View>(R.id.edTextNumber) as TextView
        val sharedPreferences: SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val intTextNumber = sharedPreferences.getInt("keyTextNumber", 0)
        val intLoanAmount = sharedPreferences.getInt("keyLoanAmount", 0)
        val decROI = sharedPreferences.getFloat("keyROI", 0f)
        val dectv3: Float
        //formula for calculation of EMI
        dectv3 = (intLoanAmount * (1 + decROI * intTextNumber)
                / (intTextNumber * 12))
        val decimalFormat = DecimalFormat("$,###,##,##,###.###")
        tv3.text = "Monthly Payment " + decimalFormat.format(dectv3.toDouble())
    }
}