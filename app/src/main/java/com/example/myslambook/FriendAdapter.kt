package com.example.myslambook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myslambook.databinding.SlambookItemBinding

class FriendAdapter(
    private val friends: List<SlambookEntry>,
    private val itemClickListener: (SlambookEntry) -> Unit,
    private val onItemDeleted: (Int) -> Unit,
    private val onItemEdited: (Int) -> Unit
) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val binding = SlambookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(friends[position], position)
    }

    override fun getItemCount(): Int = friends.size

    inner class FriendViewHolder(private val binding: SlambookItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(friend: SlambookEntry, position: Int) {
            binding.name.text = friend.fullName
            binding.root.setOnClickListener {
                itemClickListener(friend)
            }

            // Set delete button functionality
            binding.delete.setOnClickListener {
                onItemDeleted(position)
            }

            // Set edit button functionality
            binding.edit.setOnClickListener {
                onItemEdited(position)
            }
        }
    }
}
