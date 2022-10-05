package com.example.chapter5_topic4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.chapter5_topic4.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUS.setOnClickListener{
            setLocale("en")
        }
        binding.btnArab.setOnClickListener{
            setLocale("ar")
        }

        binding.btnSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    fun setLocale(lang : String?){
        val mylocale = Locale(lang)
        val res = resources
        val conf = res.configuration
        conf.locale = mylocale
        res.updateConfiguration(conf,res.displayMetrics)
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}