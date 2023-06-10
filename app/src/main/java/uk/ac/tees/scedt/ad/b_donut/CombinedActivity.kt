package uk.ac.tees.scedt.ad.b_donut

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import java.util.concurrent.Executor

class CombinedActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo
    private lateinit var StatusAuth: TextView
    private lateinit var AuthBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)

        // Initialize login views
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            if (username.text.toString() == "user" && password.text.toString() == "1234") {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
            }
        }

        // Initialize biometric authentication views
        executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(
            this@CombinedActivity,
            executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {
                    super.onAuthenticationError(errorCode, errString)
                    //auth error, stop task requires auth
                    StatusAuth.text = "Authentication Error:$errString"
                    Toast.makeText(
                        this@CombinedActivity,
                        "Authentication Error:$errString",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    //auth success, do task requires auth
                    StatusAuth.text = "Authentication Succeed...!"
                    Toast.makeText(
                        this@CombinedActivity,
                        "Authentication Succeed",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    StatusAuth.text = "Authentication Failed"
                    Toast.makeText(
                        this@CombinedActivity,
                        "Authentication Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric Authentication")
            .setDescription("Use your biometric credential")
            .setNegativeButtonText("Use App Password")
            .build()

        // Set biometric authentication click listener
        AuthBtn = findViewById(R.id.authBtn)
        AuthBtn.setOnClickListener {
            // show auth dialog
            biometricPrompt.authenticate(promptInfo)
        }
    }
}
