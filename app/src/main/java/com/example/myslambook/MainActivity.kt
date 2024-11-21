package com.example.myslambook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ViewBinding property
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle the "Get started" button click
        binding.signInButton.setOnClickListener {
            // Navigate to LoginActivity when the button is clicked
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)  // Start LoginActivity
        }
    }
}
