package com.example.mytvbelozerovklim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Timer
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timer().schedule(SPLASH_DELAY) {
            startActivity(Intent(this@MainActivity, AuthActivity::class.java))
            finish()
        }
    }
}