package com.example.myslambook

import SlambookItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myslambook.databinding.SlambookItemBinding

class SlambookAdapter(
    private var items: MutableList<SlambookEntry>,
    private val itemClickListener: (SlambookEntry) -> Unit,
    private val onItemDeleted: (Int) -> Unit,
    private val onItemEdited: (Int) -> Unit

) : RecyclerView.Adapter<SlambookAdapter.SlambookViewHolder>() {

    inner class SlambookViewHolder(private val binding: SlambookItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SlambookEntry, position: Int) {
            //   binding.profileImage.setImageResource(item.profileImage)
            binding.name.setText(item.fullName)

            // Set up click listener for the entire item view
            binding.root.setOnClickListener {

                itemClickListener(item)

            }

            // Handle edit icon click
            binding.delete.setOnClickListener {
                onItemDeleted(position)
            }

            // Set edit button functionality
            binding.edit.setOnClickListener {
                onItemEdited(position)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlambookViewHolder {
        val binding =
            SlambookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SlambookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SlambookViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int = items.size
    fun updateList(newList: List<SlambookEntry>) {
        items = newList.toMutableList() // Update the adapter's list
        notifyDataSetChanged() // Refresh the RecyclerView
    }

}
