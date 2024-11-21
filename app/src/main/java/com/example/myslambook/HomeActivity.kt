package com.example.myslambook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    // ViewBinding property
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ViewBinding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
