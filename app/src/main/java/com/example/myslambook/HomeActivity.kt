package com.example.myslambook

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myslambook.databinding.ActivityHomeBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val friends = mutableListOf<SlambookEntry>()
    private lateinit var friendAdapter: FriendAdapter

    private val friendEditorLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val updatedFriend = result.data?.getParcelableExtra<SlambookEntry>("updated_friend")
                updatedFriend?.let { handleFriendUpdate(it) }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences: SharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE)

        loadData(sharedPreferences)
        loadFriends()
        setupRecyclerView()

        binding.show.setOnClickListener{
            if (binding.content.visibility == GONE) {
                binding.content.visibility = VISIBLE
                binding.show.setImageResource(R.drawable.btn_up)
            } else {
                binding.content.visibility = GONE
                binding.show.setImageResource(R.drawable.bt_down)
            }
        }

        binding.fab.setOnClickListener {
            val intent = Intent(this, FriendEditor::class.java)
            friendEditorLauncher.launch(intent)
        }
        binding.settingsIcon.setOnClickListener{
            val edit = Intent(this, AboutMe::class.java)
            startActivity(edit)
        }
    }

    private fun setupRecyclerView() {
        friendAdapter = FriendAdapter(
            friends,
            { friend -> editFriend(friend) },  // Pass the 'SlambookEntry' to editFriend
            { position -> deleteFriend(position) },
            { position -> editFriend(friends[position]) }  // Pass the 'SlambookEntry' by accessing it from the list
        )

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = friendAdapter
        }
    }


    private fun handleFriendUpdate(updatedFriend: SlambookEntry) {
        val position = friends.indexOfFirst { friend -> friend.fullName == updatedFriend.fullName }
        if (position != -1) {
            friends[position] = updatedFriend
            friendAdapter.notifyItemChanged(position)
        } else {
            friends.add(updatedFriend)
            friendAdapter.notifyItemInserted(friends.size - 1)
        }
        saveFriends()
    }

    private fun deleteFriend(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirm Deletion")
            .setMessage("Are you sure you want to delete this friend?")
            .setPositiveButton("Yes") { _, _ ->
                friends.removeAt(position)
                saveFriends()
                friendAdapter.notifyItemRemoved(position)
                Toast.makeText(this, "Friend deleted", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun editFriend(friend: SlambookEntry) {
        val intent = Intent(this, FriendEditor::class.java)
        intent.putExtra("friend_data", friend)  // Corrected to pass 'SlambookEntry' instead of 'Int'
        friendEditorLauncher.launch(intent)
    }

    private fun saveFriends() {
        val sharedPreferences = getSharedPreferences("MyAppPreferences", MODE_PRIVATE)
        sharedPreferences.edit().putString("friends_list", Gson().toJson(friends)).apply()
    }

    private fun loadFriends() {
        val sharedPreferences = getSharedPreferences("MyAppPreferences", MODE_PRIVATE)
        val friendsJson = sharedPreferences.getString("friends_list", null)
        if (!friendsJson.isNullOrEmpty()) {
            val type = object : TypeToken<List<SlambookEntry>>() {}.type
            val loadedFriends: List<SlambookEntry> = Gson().fromJson(friendsJson, type)
            friends.addAll(loadedFriends)
        }
    }
    private fun loadData(sharedPreferences: SharedPreferences) {
        val name = sharedPreferences.getString("name", "Unknown Name")
        val gender = sharedPreferences.getString("gender", "Unknown Gender")
        val age = sharedPreferences.getString("age", "Unknown")
        val status = sharedPreferences.getString("status", "Unknown")
        val contact = sharedPreferences.getString("contact", "Unknown")
        val address = sharedPreferences.getString("address", "Unknown Address")




        binding.nameText.text = name
        binding.genderValue.text = gender
        binding.ageValue.text = age
        binding.addressValue.text = address
        binding.phoneValue.text = contact
        binding.statusValue.text = status
    }
}
