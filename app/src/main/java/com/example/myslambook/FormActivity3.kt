import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook.HomeActivity
import com.example.myslambook.SlambookEntry
import com.example.myslambook.SlambookResparatory
import com.example.myslambook.databinding.ActivityForm3Binding

class FormActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityForm3Binding
    private lateinit var slambookEntry: SlambookEntry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the ViewBinding
        binding = ActivityForm3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the SlambookEntry object from the Intent
        slambookEntry = intent.getSerializableExtra("slambookEntry") as SlambookEntry


        binding.etFavoriteHobby.setText(slambookEntry.favoriteHobby)
        binding.etBooksOrMovies.setText(slambookEntry.booksOrMovies)
        binding.etSportOrGame.setText(slambookEntry.sportOrGame)
        binding.etDrawingOrPainting.setText(slambookEntry.drawingOrPainting)
        binding.etFunHobby.setText(slambookEntry.funHobby)
        binding.etVideoGames.setText(slambookEntry.videoGames)
        binding.etCookingOrBaking.setText(slambookEntry.cookingOrBaking)
        binding.etNewHobby.setText(slambookEntry.newHobby)
        binding.etIndoorOrOutdoor.setText(slambookEntry.indoorOrOutdoor)
        binding.etHobbyWithFriends.setText(slambookEntry.hobbyWithFriends)

        // Handle Previous button click
        binding.btnPrevious.setOnClickListener {
            // Optionally, go back to the previous activity
            finish()
        }

        // Handle Save button click
        binding.btnSave.setOnClickListener {
            // Get input data from the form
            val favoriteHobby = binding.etFavoriteHobby.text.toString()
            val booksOrMovies = binding.etBooksOrMovies.text.toString()
            val sportOrGame = binding.etSportOrGame.text.toString()
            val drawingOrPainting = binding.etDrawingOrPainting.text.toString()
            val funHobby = binding.etFunHobby.text.toString()
            val videoGames = binding.etVideoGames.text.toString()
            val cookingOrBaking = binding.etCookingOrBaking.text.toString()
            val newHobby = binding.etNewHobby.text.toString()
            val indoorOrOutdoor = binding.etIndoorOrOutdoor.text.toString()
            val hobbyWithFriends = binding.etHobbyWithFriends.text.toString()

            // Update the SlambookEntry object with new values
            slambookEntry.favoriteHobby = favoriteHobby
            slambookEntry.booksOrMovies = booksOrMovies
            slambookEntry.sportOrGame = sportOrGame
            slambookEntry.drawingOrPainting = drawingOrPainting
            slambookEntry.funHobby = funHobby
            slambookEntry.videoGames = videoGames
            slambookEntry.cookingOrBaking = cookingOrBaking
            slambookEntry.newHobby = newHobby
            slambookEntry.indoorOrOutdoor = indoorOrOutdoor
            slambookEntry.hobbyWithFriends = hobbyWithFriends



            SlambookResparatory.addSlambook(slambookEntry)

            // Show a success message
            Toast.makeText(this, "Your slambook entry is saved!", Toast.LENGTH_SHORT).show()

            // Go back to the home activity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            // Optionally, finish the current activity
            finish()
        }
    }
}
