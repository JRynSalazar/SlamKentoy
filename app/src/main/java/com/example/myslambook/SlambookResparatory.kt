package com.example.myslambook

import com.example.myslambook.SlambookEntry

object SlambookResparatory {
    // Private list to hold SlambookEntry objects
    private val slambooks = mutableListOf<SlambookEntry>()

    // Function to add a SlambookEntry to the list
    fun addSlambook(slambook: SlambookEntry) {
        slambooks.add(slambook)
    }

    // Function to get the list of all SlambookEntries
    fun getSlambooks(): List<SlambookEntry> = slambooks

    // Optional: You can add more functions like removing or updating a slambook if needed
    fun removeSlambook(slambook: SlambookEntry) {
        slambooks.remove(slambook)
    }

    // Function to get a specific SlambookEntry by fullName
    fun getSlambookByFullName(fullName: String): SlambookEntry? {
        return slambooks.find { it.fullName == fullName }
    }
}
