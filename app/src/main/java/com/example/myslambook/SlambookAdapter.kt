package com.example.myslambook

import SlambookItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myslambook.databinding.SlambookItemBinding

class SlambookAdapter(
    private val items: MutableList<SlambookItem>,
    private val itemClickListener: (SlambookItem) -> Unit // Add a listener for click events
) : RecyclerView.Adapter<SlambookAdapter.SlambookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlambookViewHolder {
        val binding = SlambookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SlambookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SlambookViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class SlambookViewHolder(private val binding: SlambookItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SlambookItem) {
            binding.profileImage.setImageResource(item.profileImage)
            binding.nameInput.setText(item.name)

            // Set up click listener for the entire item view
            binding.root.setOnClickListener {

                itemClickListener(item)

            }

            // Handle edit icon click
            binding.editIcon.setOnClickListener {
                // Handle edit logic here
            }

            // Handle delete icon click
            binding.deleteIcon.setOnClickListener {
                // Handle delete logic here
            }
        }
    }
}
