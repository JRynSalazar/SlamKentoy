package com.example.myslambook

import android.animation.LayoutTransition
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook.databinding.ActivityFriendEditorBinding

class FriendEditor : AppCompatActivity() {
    private lateinit var binding: ActivityFriendEditorBinding
    private var friend: SlambookEntry? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFriendEditorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        friend = intent.getParcelableExtra("friend_data")
        loadFriendData()

        binding.save.setOnClickListener {
            saveFriendData()
        }
        binding.favCard.layoutTransition = LayoutTransition()
        binding.HobCard.layoutTransition = LayoutTransition()

        binding.igmFav.setOnClickListener {
            val visibility =
                if (binding.favCard.visibility == View.GONE) View.VISIBLE else View.GONE
            binding.favCard.visibility = visibility
            binding.igmFav.visibility = visibility
            binding.hobbies.visibility = View.GONE
        }

        binding.imgHob.setOnClickListener {
            val visibility =
                if (binding.HobCard.visibility == View.GONE) View.VISIBLE else View.GONE
            binding.HobCard.visibility = visibility
            binding.imgHob.visibility = visibility
            binding.favorite.visibility = View.GONE
        }

        binding.save1.setOnClickListener {
            binding.favCard.visibility = View.GONE
            binding.igmFav.visibility = View.VISIBLE
            binding.favorite.visibility = View.VISIBLE
            binding.hobbies.visibility = View.VISIBLE
        }

        binding.save2.setOnClickListener {
            binding.HobCard.visibility = View.GONE
            binding.imgHob.visibility = View.VISIBLE
            binding.hobbies.visibility = View.VISIBLE
            binding.favorite.visibility = View.VISIBLE
        }
    }

    private fun saveFriendData() {
        val updatedFriend = SlambookEntry(
            fullName = binding.nameAcc.text.toString(),
            birthday = binding.bday.text.toString(),
            favoriteColor = binding.etFavoriteColor.text.toString(),
            favoriteFood = binding.etFavoriteFood.text.toString(),
            favoriteMovie = binding.etFavoriteMovie.text.toString(),
            favoriteHobby = binding.etFavoriteHobby.text.toString(),
            pets = binding.etPets.text.toString(),
            favoriteSeason = binding.etFavoriteSeason.text.toString(),
            favoriteCelebrity = binding.etFavoriteCelebrity.text.toString(),
            cantLiveWithout = binding.etCantLiveWithout.text.toString(),
            vacationDestination = binding.etVacationDestination.text.toString(),
            favoriteHobbyFromHobbies = binding.etFavoriteHobby2.text.toString(),
            booksOrMovies = binding.etBooksOrMovies.text.toString(),
            sportOrGame = binding.etSportOrGame.text.toString(),
            drawingOrPainting = binding.etDrawingOrPainting.text.toString(),
            funHobby = binding.etFunHobby.text.toString(),
            videoGames = binding.etVideoGames.text.toString(),
            cookingOrBaking = binding.etCookingOrBaking.text.toString(),
            newHobby = binding.etNewHobby.text.toString(),
            indoorOrOutdoor = binding.etIndoorOrOutdoor.text.toString(),
            hobbyWithFriends = binding.etHobbyWithFriends.text.toString(),
        )
        val resultIntent = Intent()
        resultIntent.putExtra("updated_friend", updatedFriend)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    private fun loadFriendData() {
        friend?.let {
            binding.nameAcc.setText(it.fullName)
            binding.bday.setText(it.birthday)
            binding.etFavoriteColor.setText(it.favoriteColor)
            binding.etFavoriteFood.setText(it.favoriteFood)
            binding.etFavoriteMovie.setText(it.favoriteMovie)
            binding.etFavoriteHobby.setText(it.favoriteHobby)
            binding.etPets.setText(it.pets)
            binding.etFavoriteSeason.setText(it.favoriteSeason)
            binding.etFavoriteCelebrity.setText(it.favoriteCelebrity)
            binding.etCantLiveWithout.setText(it.cantLiveWithout)
            binding.etVacationDestination.setText(it.vacationDestination)
            binding.etFavoriteHobby2.setText(it.favoriteHobbyFromHobbies)
            binding.etBooksOrMovies.setText(it.booksOrMovies)
            binding.etSportOrGame.setText(it.sportOrGame)
            binding.etDrawingOrPainting.setText(it.drawingOrPainting)
            binding.etFunHobby.setText(it.funHobby)
            binding.etVideoGames.setText(it.videoGames)
            binding.etCookingOrBaking.setText(it.cookingOrBaking)
            binding.etNewHobby.setText(it.newHobby)
            binding.etIndoorOrOutdoor.setText(it.indoorOrOutdoor)
            binding.etHobbyWithFriends.setText(it.hobbyWithFriends)
        }
    }
}
