package com.example.myslambook

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook.databinding.ActivityAboutMeBinding

class AboutMe : AppCompatActivity() {
    private lateinit var binding: ActivityAboutMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Reference the profileImg from the binding object
        val profileImg: ImageView = binding.profileImg

        val sharedPreferences: SharedPreferences =
            getSharedPreferences("AppPreferences", MODE_PRIVATE)

        binding.save.setOnClickListener {
            saveData(sharedPreferences, profileImg) // Pass the profileImg to saveData
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        loadData(sharedPreferences, profileImg) // Pass profileImg to loadData
    }

    private fun saveData(sharedPreferences: SharedPreferences, profileImg: ImageView) {
        val name = binding.nameValue.text.toString()
        val age = binding.ageValue.text.toString()
        val gender = binding.genderSpinner.selectedItem.toString()
        val status = binding.statusSpinner.selectedItem.toString()
        val address = binding.addressValue.text.toString()
        val contact = binding.phoneValue.text.toString()

        // Validation for required fields and valid spinner selections
        if (name.isEmpty() || age.isEmpty() || address.isEmpty() || contact.isEmpty() ||
            gender == "Select" || status == "Select"
        ) {
            Toast.makeText(this, "Please fill all fields and select valid options!", Toast.LENGTH_SHORT).show()
            return
        }

        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("gender", gender) // Save gender here
        editor.putString("status", status)
        editor.putString("age", age)
        editor.putString("address", address)
        editor.putString("contact", contact)

        editor.apply()
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()

        // Update avatar based on selected gender
        updateAvatar(gender, profileImg)
    }

    private fun loadData(sharedPreferences: SharedPreferences, profileImg: ImageView) {
        binding.nameValue.setText(sharedPreferences.getString("name", ""))
        binding.ageValue.setText(sharedPreferences.getString("age", ""))
        binding.addressValue.setText(sharedPreferences.getString("address", ""))
        binding.phoneValue.setText(sharedPreferences.getString("contact", ""))

        // Set the gender spinner based on the saved value or default to "Select"
        val gender = sharedPreferences.getString("gender", "Select")
        val genderPosition = resources.getStringArray(R.array.gender_options).indexOf(gender)
        binding.genderSpinner.setSelection(if (genderPosition >= 0) genderPosition else 0)

        // Set the status spinner based on the saved value or default to "Select"
        val status = sharedPreferences.getString("status", "Select")
        val statusPosition = resources.getStringArray(R.array.status_options).indexOf(status)
        binding.statusSpinner.setSelection(if (statusPosition >= 0) statusPosition else 0)

        // Update the avatar if gender is not "Select"
        if (gender != "Select") {
            updateAvatar(gender ?: "", profileImg)
        }
    }

    // Function to update the avatar based on gender
    private fun updateAvatar(gender: String, profileImg: ImageView) {
        when (gender) {
            "Male" -> profileImg.setImageResource(R.drawable.male_ic) // Set male avatar
            "Female" -> profileImg.setImageResource(R.drawable.female_ic) // Set female avatar
            else -> profileImg.setImageResource(R.drawable.lgbtq_flag) // Set LGBTQ flag
        }
    }
}
