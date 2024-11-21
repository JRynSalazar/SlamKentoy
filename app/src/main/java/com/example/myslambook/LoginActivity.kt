package com.example.myslambook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DatabaseHelper(this)

        binding.signInButton.setOnClickListener {
            val username = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            // Basic validation
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Validate user credentials in the database
                val isValid = dbHelper.validateUser(username, password)

                if (isValid) {
                    // Credentials are correct, navigate to HomeActivity
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()  // Close LoginActivity
                } else {
                    // Show error if credentials are incorrect
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Handle sign up text click (navigate to CreateAccountActivity)
        binding.signUpText.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)  // Navigate to CreateAccountActivity
        }
    }
}
