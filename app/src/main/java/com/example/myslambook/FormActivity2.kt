import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook.SlambookEntry
import com.example.myslambook.SlambookResparatory
import com.example.myslambook.databinding.ActivityForm2Binding

class FormActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityForm2Binding
    private lateinit var slambookEntry: SlambookEntry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the ViewBinding
        binding = ActivityForm2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the SlambookEntry object from the Intent
        slambookEntry = intent.getSerializableExtra("slambookEntry") as SlambookEntry

        // Set the form fields with existing data
        binding.etFavoriteColor.setText(slambookEntry.favoriteColor)
        binding.etFavoriteFood.setText(slambookEntry.favoriteFood)
        binding.etFavoriteMovie.setText(slambookEntry.favoriteMovie)
        binding.etFavoriteHobby.setText(slambookEntry.favoriteHobby)
        binding.etPets.setText(slambookEntry.pets)
        binding.etFavoriteSeason.setText(slambookEntry.favoriteSeason)
        binding.etFavoriteCelebrity.setText(slambookEntry.favoriteCelebrity)
        binding.etCantLiveWithout.setText(slambookEntry.cantLiveWithout)
        binding.etVacationDestination.setText(slambookEntry.vacationDestination)

        // Handle Next button click
        binding.btnNext.setOnClickListener {
            // Get input data from the form
            val favoriteColor = binding.etFavoriteColor.text.toString()
            val favoriteFood = binding.etFavoriteFood.text.toString()
            val favoriteMovie = binding.etFavoriteMovie.text.toString()
            val favoriteHobby = binding.etFavoriteHobby.text.toString()
            val pets = binding.etPets.text.toString()
            val favoriteSeason = binding.etFavoriteSeason.text.toString()
            val favoriteCelebrity = binding.etFavoriteCelebrity.text.toString()
            val cantLiveWithout = binding.etCantLiveWithout.text.toString()
            val vacationDestination = binding.etVacationDestination.text.toString()

            // Update the SlambookEntry object with new values
            slambookEntry.favoriteColor = favoriteColor
            slambookEntry.favoriteFood = favoriteFood
            slambookEntry.favoriteMovie = favoriteMovie
            slambookEntry.favoriteHobby = favoriteHobby
            slambookEntry.pets = pets
            slambookEntry.favoriteSeason = favoriteSeason
            slambookEntry.favoriteCelebrity = favoriteCelebrity
            slambookEntry.cantLiveWithout = cantLiveWithout
            slambookEntry.vacationDestination = vacationDestination

            // Store the updated SlambookEntry in the repository
            SlambookResparatory.addSlambook(slambookEntry)

            // Show a success message
            Toast.makeText(this, "Your slambook entry is saved!", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, FormActivity3::class.java))  // if there's another activity
            finish() // Finish this activity
        }

        // Handle Previous button click
        binding.btnPrevious.setOnClickListener {
            // Optionally, go back to the previous activity
            finish()
        }
    }
}
