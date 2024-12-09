package com.example.myslambook

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Base64
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myslambook.databinding.ActivityAboutMeBinding

class AboutMe : AppCompatActivity() {
    private lateinit var binding: ActivityAboutMeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sharedPreferences: SharedPreferences =
            getSharedPreferences("AppPreferences", MODE_PRIVATE)
        binding.save.setOnClickListener {
            saveData(sharedPreferences)
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        loadData(sharedPreferences)

    }

    private fun saveData(sharedPreferences: SharedPreferences) {


        val name = binding.nameValue.text.toString()
        val age = binding.ageValue.text.toString()
        val gender = binding.genderValue.text.toString()
        val address = binding.addressValue.text.toString()
        val contact = binding.phoneValue.text.toString()
        val status = binding.statusValue.text.toString()

        if (name.isEmpty() || age.isEmpty() || gender.isEmpty() ||
            address.isEmpty() || contact.isEmpty() || status.isEmpty()
        ) {
            Toast.makeText(this, "Please fill all Fields!", Toast.LENGTH_SHORT).show()
            return
        }
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("gender", gender)
        editor.putString("status", status)
        editor.putString("age", age)
        editor.putString("address", address)
        editor.putString("contact", contact)


        editor.apply()
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()

    }

    private fun loadData(sharedPreferences: SharedPreferences) {
        binding.nameValue.setText(sharedPreferences.getString("name", ""))
        binding.ageValue.setText(sharedPreferences.getString("age", ""))
        binding.genderValue.setText(sharedPreferences.getString("gender", ""))
        binding.addressValue.setText(sharedPreferences.getString("address", ""))
        binding.phoneValue.setText(sharedPreferences.getString("contact", ""))
        binding.statusValue.setText(sharedPreferences.getString("status", ""))
    }
}