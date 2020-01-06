package com.mohamedsahassanb.findmyage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.mohamedsahassanb.findmyage.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
     private var birthYear = ""
    private var yearOfBirth = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.findAgeBtn.setOnClickListener {
            calculateAge()
        }
        binding.refreshBtn.setOnClickListener {
            reset()
        }
    }

    private fun reset() {
        when{
            (yearOfBirth >0) -> resetBirthYear()
        }

    }

    private fun resetBirthYear() {
        binding.birthYearText.text.clear()
    }

    private fun calculateAge() {
         birthYear = binding.birthYearText.text.toString()
        if (birthYear == ""){
            yearOfBirth = 0
            Toast.makeText(this,"please enter your birth year",Toast.LENGTH_LONG).show()
            return
        }else
            yearOfBirth=birthYear.toInt()
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val age = currentYear-yearOfBirth
        binding.viewAge.text = "Your Age Is $age years"
    }
}
