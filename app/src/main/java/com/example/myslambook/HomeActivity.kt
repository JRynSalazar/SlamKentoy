package com.example.myslambook
import DisplayActivity1
import SlambookItem
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myslambook.databinding.ActivityForm1Binding
import com.example.myslambook.databinding.ActivityForm2Binding
import com.example.myslambook.databinding.ActivityHomeBinding
import com.example.myslambook.databinding.ActivityForm3Binding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var slambookAdapter: SlambookAdapter
    private val slambookItems = mutableListOf<SlambookItem>()

    // Variables to store form data
    private var fullName: String? = null
    private var nickname: String? = null
    private var birthday: String? = null
    private var status: String? = null
    private var zodiacSign: String? = null
    private var address: String? = null
    private var contactNo: String? = null
    private var gender: String? = null
    private var favoriteHobby: String? = null
    private var favoriteColor: String? = null
    private var favoriteFood: String? = null
    private var favoriteMovie: String? = null
    private var pets: String? = null
    private var favoriteSeason: String? = null
    private var favoriteCelebrity: String? = null
    private var cantLiveWithout: String? = null
    private var vacationDestination: String? = null
    private var booksOrMovies: String? = null
    private var sportOrGame: String? = null
    private var drawingOrPainting: String? = null
    private var funHobby: String? = null
    private var videoGames: String? = null
    private var cookingOrBaking: String? = null
    private var newHobby: String? = null
    private var indoorOrOutdoor: String? = null
    private var hobbyWithFriends: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)




        slambookAdapter = SlambookAdapter(slambookItems) { item ->
            val intent = Intent(this, DisplayActivity1::class.java)

            startActivity(intent)


            Toast.makeText(this, "Item clicked: ${item.name}", Toast.LENGTH_SHORT).show()
        }

        val newItem = SlambookItem(
            profileImage = R.drawable.ic_profile,
            name = fullName ?: "No Name",


            )

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = slambookAdapter
        }


        binding.fab.setOnClickListener {
            showPopupOne()
        }
    }

    private fun showPopupOne() {
        val dialog = Dialog(this)
        val popupBinding = ActivityForm1Binding.inflate(layoutInflater)
        dialog.setContentView(popupBinding.root)
        dialog.window?.setLayout(730, LinearLayout.LayoutParams.WRAP_CONTENT)

        popupBinding.next.setOnClickListener {
            // Capture data from Form 1
            fullName = popupBinding.etFullName.text.toString()
            nickname = popupBinding.etNickname.text.toString()
            birthday = popupBinding.etBirthday.text.toString()
            status = popupBinding.etStatus.text.toString()
            zodiacSign = popupBinding.etZodiacSign.text.toString()
            address = popupBinding.etAddress.text.toString()
            contactNo = popupBinding.etContactNo.text.toString()

            val selectedGenderId = popupBinding.genderGroup.checkedRadioButtonId
            gender = when (selectedGenderId) {
                R.id.radioMale -> "Male"
                R.id.radioFemale -> "Female"
                R.id.radioOther -> "Other"
                else -> ""
            }


            dialog.dismiss()
            showPopupTwo()
        }

        dialog.setCancelable(true)
        dialog.show()
    }

    private fun showPopupTwo() {
        val dialog = Dialog(this)
        val popupBinding = ActivityForm2Binding.inflate(layoutInflater)
        dialog.setContentView(popupBinding.root)
        dialog.window?.setLayout(730, LinearLayout.LayoutParams.WRAP_CONTENT)

        popupBinding.btnPrevious.setOnClickListener {
            dialog.dismiss()
            showPopupOne() // Navigate back to Form 1
        }

        popupBinding.btnNext.setOnClickListener {
            // Capture data from Form 2
            favoriteHobby = popupBinding.etFavoriteHobby.text.toString()
            favoriteColor = popupBinding.etFavoriteColor.text.toString()
            favoriteFood = popupBinding.etFavoriteFood.text.toString()
            favoriteMovie = popupBinding.etFavoriteMovie.text.toString()
            pets = popupBinding.etPets.text.toString()
            favoriteSeason = popupBinding.etFavoriteSeason.text.toString()
            favoriteCelebrity = popupBinding.etFavoriteCelebrity.text.toString()
            cantLiveWithout = popupBinding.etCantLiveWithout.text.toString()
            vacationDestination = popupBinding.etVacationDestination.text.toString()

            dialog.dismiss()
            showPopupThree() // Navigate to Form 3
        }

        dialog.setCancelable(true)
        dialog.show()
    }


    private fun showPopupThree() {
        val dialog = Dialog(this)
        val popupBinding = ActivityForm3Binding.inflate(layoutInflater)
        dialog.setContentView(popupBinding.root)
        dialog.window?.setLayout(730, LinearLayout.LayoutParams.WRAP_CONTENT)

        popupBinding.btnSave.setOnClickListener {
            // Capture data from Form 3
            favoriteHobby = popupBinding.etFavoriteHobby.text.toString()
            booksOrMovies = popupBinding.etBooksOrMovies.text.toString()
            sportOrGame = popupBinding.etSportOrGame.text.toString()
            drawingOrPainting = popupBinding.etDrawingOrPainting.text.toString()
            funHobby = popupBinding.etFunHobby.text.toString()
            videoGames = popupBinding.etVideoGames.text.toString()
            cookingOrBaking = popupBinding.etCookingOrBaking.text.toString()
            newHobby = popupBinding.etNewHobby.text.toString()
            indoorOrOutdoor = popupBinding.etIndoorOrOutdoor.text.toString()
            hobbyWithFriends = popupBinding.etHobbyWithFriends.text.toString()

            // Create a new SlambookItem and add it to the list
            val newItem = SlambookItem(
                profileImage = R.drawable.ic_profile,  // Placeholder image
                name = fullName ?: "No Name",  // Use a fallback if fullName is null
                //editIcon = R.drawable.ic_edit,  // Edit icon
                //    deleteIcon = R.drawable.ic_delete  // Delete icon
            )
            slambookItems.add(newItem)

            // Notify the adapter that a new item has been inserted
            slambookAdapter.notifyItemInserted(slambookItems.size - 1)

            dialog.dismiss()
        }

        dialog.setCancelable(true)
        dialog.show()
    }
}

