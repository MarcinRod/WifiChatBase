package com.example.wifichat.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wifichat.databinding.MessageViewHolderBinding
import com.example.wifichat.model.ChatMessage

/**
 * Adapter for the RecyclerView displaying the chat messages
 * The owner of the adapter is used to differentiate the messages in the adapter
 */
class ChatMessageRecyclerViewAdapter :
    ListAdapter<ChatMessage, ChatMessageRecyclerViewAdapter.ViewHolder>(Comparator) {
    // Variable holding the name of the owner of this adapter -
    // used to differentiate the messages in the adapter
    private var owner: String? = null

    /**
     * Sets the owner of the adapter
     * @param owner - the name of the owner
     */
    fun setOwner(owner: String) {
        this.owner = owner
    }

    // An object used to determine if two items represent the same ChatMessage object
    object Comparator : DiffUtil.ItemCallback<ChatMessage>() {
        override fun areItemsTheSame(oldItem: ChatMessage, newItem: ChatMessage): Boolean {
            return oldItem === newItem
        }

        // An object used to determine if two items have the same contents
        override fun areContentsTheSame(oldItem: ChatMessage, newItem: ChatMessage): Boolean {
            return oldItem.timestamp == newItem.timestamp &&
                    oldItem.message == newItem.message &&
                    oldItem.author == newItem.author
        }
    }

    // Creates a new ViewHolder object for displaying items in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the view using the MessageViewHolderBinding object
        return ViewHolder(
            MessageViewHolderBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    // Binds a ChatMessage object to a ViewHolder object
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the ChatMessage object at the specified position in the list of items
        val item = getItem(position)
        // Bind the ChatMessage object to the ViewHolder object
        holder.bind(item)
    }

    // A ViewHolder object for displaying a single ChatMessage object
    inner class ViewHolder(private val binding: MessageViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {


        // Binds a ChatMessage object to the ViewHolder object
        fun bind(message: ChatMessage) {

        }
    }

}
