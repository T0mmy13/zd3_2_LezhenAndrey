package com.example.mytvbelozerovklim

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {

    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText:EditText
    private lateinit var loginButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        loginEditText = findViewById(R.id.loginEditText)
        passwordEditText =  findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)


        loginButton.setOnClickListener {
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (login == "ects" && password == "ects2024") {
                startActivity(Intent(this, FilmsActivity::class.java))
            } else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
                loginEditText.error = "Неверный логин"
                passwordEditText.error = "Неверный пароль"
            }
        }
    }
}