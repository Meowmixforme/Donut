package uk.ac.tees.scedt.ad.b_donut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenuActivity : AppCompatActivity() {
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        button1 = findViewById(R.id.button1)
        button1.setOnClickListener {
            var intent = Intent(this, DonateActivity::class.java)
            startActivity(intent)
        }
        button2 = findViewById(R.id.button2)
        button2.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        button3 = findViewById(R.id.button3)
        button3.setOnClickListener {
            var intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
        button4 = findViewById(R.id.button4)
        button4.setOnClickListener {
            var intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
        button5 = findViewById(R.id.button5)
        button5.setOnClickListener {
            var intent = Intent(this, RegActivity1::class.java)
            startActivity(intent)
        }
    }
}