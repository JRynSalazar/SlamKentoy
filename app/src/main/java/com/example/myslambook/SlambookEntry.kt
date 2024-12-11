package com.example.myslambook

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class SlambookEntry(
    val fullName: String,
    val age: String,
    val gender: String,
    val address: String,
    val favoriteColor: String,
    val favoriteFood: String,
    val favoriteMovie: String,
    val favoriteHobby: String,
    val pets: String,
    val favoriteSeason: String,
    val favoriteCelebrity: String,
    val cantLiveWithout: String,
    val vacationDestination: String,
    val favoriteHobbyFromHobbies: String,
    val booksOrMovies: String,
    val sportOrGame: String,
    val drawingOrPainting: String,
    val funHobby: String,
    val videoGames: String,
    val cookingOrBaking: String,
    val newHobby: String,
    val indoorOrOutdoor: String,
    val hobbyWithFriends: String
) : Parcelable
