package com.example.forecastapplication.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.forecastapplication.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var rotation = AnimationUtils.loadAnimation(this, R.anim.rotation)
        var appearance = AnimationUtils.loadAnimation(this, R.anim.appearance)
        sun_icon.startAnimation(rotation)
        title_forecast.startAnimation(appearance)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity (intent)
            finish()
        }, 5000)


    }
}
