import android.os.Bundle

import android.view.View

import android.widget.EditText

import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.button.MaterialButton
import uk.ac.tees.scedt.ad.b_donut.R


class RegActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.reg_main)



        val username = findViewById<EditText>(R.id.username)

        val regbtn = findViewById<MaterialButton>(R.id.signupbtn)



        regbtn.setOnClickListener(View.OnClickListener {

            val username1 = username.text.toString()

            Toast.makeText(this@RegActivity2, "Username is $username1", Toast.LENGTH_SHORT).show()

        })

    }

}
