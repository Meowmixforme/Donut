package uk.ac.tees.scedt.ad.b_donut

import android.annotation.SuppressLint
import android.hardware.biometrics.BiometricPrompt
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.concurrent.Executor
import javax.net.ssl.SSLEngineResult.Status


class BioMainActivity : AppCompatActivity() {
    private lateinit var executor: Executor
    private lateinit var biometricPrompt: androidx.biometric.BiometricPrompt
    private lateinit var promptInfo: androidx.biometric.BiometricPrompt.PromptInfo
    private lateinit var StatusAuth : TextView
    private lateinit var AuthBtn : Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //init biometric
        executor = ContextCompat.getMainExecutor(this)


        biometricPrompt = androidx.biometric.BiometricPrompt(
            this@BioMainActivity,
            executor,
            object : androidx.biometric.BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    //auth error, stop task requires auth

                   // StatusAuth = findViewById( id.StatusAuth)
                    StatusAuth.text = "Authentication Error:$errString"
                    Toast.makeText(
                        this@BioMainActivity,
                        "Authentication Error:$errString",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onAuthenticationSucceeded(result: androidx.biometric.BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    //auth success, do task requires auth
                    StatusAuth.text = "Authentication Succeed...!"
                    Toast.makeText(
                        this@BioMainActivity,
                        "Authentication Succeed",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    StatusAuth.text = "Authentication Failed"
                    Toast.makeText(
                        this@BioMainActivity,
                        "Authentication Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        // set properties like title  and decription om auth dialog
        promptInfo = androidx.biometric.BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric Authentication")
            .setDescription("Use your biometric credential")
            .setNegativeButtonText("Use App Password")
            .build()

        // Handle click, start authentication dialog
       // AuthBtn = findViewById( id.authBtn)
        AuthBtn.setOnClickListener {
            // show auth dialog
            biometricPrompt.authenticate(promptInfo)
        }



    }
}
