//package com.example.dougnutlogink
package uk.ac.tees.scedt.ad.b_donut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
//import com.example.dougnutlogink.databinding.ActivityMainBinding
//import uk.ac.tees.scedt.ad.b_donut.d

class LoginActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
    lateinit var username : EditText
    lateinit var password: EditText
    lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        username= findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)
        loginButton.setOnClickListener(View.OnClickListener {
            if (username.text.toString() == "user" && password.text.toString() == "1234"){
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
            }
        })
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.loginButton.setOnClickListener(View.OnClickListener {
//            if (binding.username.text.toString() == "user" && binding.password.text.toString() == "1234"){
//                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
//            }
//        })
    }
}