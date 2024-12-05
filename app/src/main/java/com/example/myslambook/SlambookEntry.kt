package com.example.myslambook

import java.io.Serializable

data class SlambookEntry(

    var fullName: String = "",
    var nickname: String = "",
    var birthday: String = "",
    var gender: String = "", // Can be "Male", "Female", "Other"
    var status: String = "",
    var zodiacSign: String = "",
    var address: String = "",
    var contactNumber: String = "",
    var profileImageUri: String? = null, // Optional field for the image URI

    // UserFavorites details
    var favoriteColor: String = "",
    var favoriteFood: String = "",
    var favoriteMovie: String = "",
    var favoriteHobby: String = "",
    var pets: String = "",  // Name of the pets, if any
    var favoriteSeason: String = "",
    var favoriteCelebrity: String = "",
    var cantLiveWithout: String = "",
    var vacationDestination: String = "",

    // UserHobbies details
    var favoriteHobbyFromHobbies: String = "",
    var booksOrMovies: String = "",
    var sportOrGame: String = "",
    var drawingOrPainting: String = "",
    var funHobby: String = "",
    var videoGames: String = "",
    var cookingOrBaking: String = "",
    var newHobby: String = "",
    var indoorOrOutdoor: String = "",
    var hobbyWithFriends: String = ""
) : Serializable
