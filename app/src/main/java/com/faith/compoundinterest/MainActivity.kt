package com.faith.compoundinterest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var principal: EditText = findViewById(R.id.principal)
        var onePlusRate: EditText = findViewById(R.id.onePlusRate)
        var period: EditText = findViewById(R.id.years)
        var COMPOUND: EditText = findViewById(R.id.btnCalculate)
        var CompoundInterest: EditText = findViewById(R.id.myResult)


        COMPOUND.setOnClickListener {
            var cash = principal.text.toString()
            var rate = onePlusRate.text.toString()
            var years = period.text.toString()
            var myResult = CompoundInterest.text.toString()


            if (cash.isEmpty() || rate.isEmpty() || years.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Null value....Please Enter All Values",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener

            }
            try {
                var principal = cash.toDouble()
                var onePlusRate = rate.toDouble()
                var period = years.toDouble()


                //A= p(1+r/100)power n
                fun compoundedDetails() = principal * (1 + rate / 100).pow(years)
                var compoundInterest = compoundedDetails()

                myResult.text = "Period $years" +
                        "Principal $cash" +
                        "Rate $rate"
            } catch (e: Exception) {
                Toast.makeText(applicationContext, "INVALID OUTPUT", Toast.LENGTH_SHORT).show()
            }


        }


    }
}


