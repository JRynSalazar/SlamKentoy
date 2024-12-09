package com.example.myslambook

import android.content.Intent
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myslambook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val gifDrawable = ContextCompat.getDrawable(this, R.drawable.gif_kenlogo) as AnimatedImageDrawable
            gifDrawable.repeatCount = 1
            binding.logoImageView.setImageDrawable(gifDrawable)
            gifDrawable.start()
        }


        binding.signInButton.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)  // Start LoginActivity
        }
    }
}
