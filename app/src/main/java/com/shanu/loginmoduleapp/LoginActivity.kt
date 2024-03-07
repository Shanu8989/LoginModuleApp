package com.shanu.loginmoduleapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.shanu.biometricDialog.CustomBiometricDialog
import com.shanu.biometricDialog.SettingsActivity
import com.shanu.loginmoduleapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var dialog: SettingsActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUI()
    }

    private fun setUI() {
        binding.btnLogin.setOnClickListener {
            val userName = binding.username.text.toString()
            val password = binding.password.text.toString()

            if (fieldsNullOrEmpty(userName, password)) {
                Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_SHORT).show()
            } else {
                dialog = SettingsActivity()
            }
        }
    }

    private fun fieldsNullOrEmpty(vararg data: String?): Boolean = data.any { it.isNullOrEmpty() }

}