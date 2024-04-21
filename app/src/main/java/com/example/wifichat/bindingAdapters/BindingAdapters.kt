package com.example.wifichat.bindingAdapters

import android.net.wifi.p2p.WifiP2pDevice
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wifichat.model.ChatMessage
import com.example.wifichat.ui.discovery.PeersRecyclerViewAdapter
import com.example.wifichat.ui.chat.ChatMessageRecyclerViewAdapter

// This file contains the binding adapters for the RecyclerViews in the app
// The binding adapters are used to set the data for the RecyclerViews
// The data is set using the LiveData objects in the ViewModel and data binding
@BindingAdapter("app:messageList")
fun setMessages(recyclerView: RecyclerView, messages: List<ChatMessage>?) {
    messages ?: return
    if (recyclerView.adapter is ChatMessageRecyclerViewAdapter) {

        // get the adapter from the recyclerView and submit the list of messages
        val adapter = recyclerView.adapter as ChatMessageRecyclerViewAdapter
        adapter.submitList(messages)

        // Scroll to the bottom of the RecyclerView when a new message is added to the list
        // post() is used to ensure that the scrolling is done after the layout is updated
        recyclerView.post {
            recyclerView.smoothScrollToPosition(messages.size)
        }

    }
}

@BindingAdapter("app:peersList")
fun setPeers(recyclerView: RecyclerView, peers: List<WifiP2pDevice>?) {
    peers ?: return
    if (recyclerView.adapter is PeersRecyclerViewAdapter) {
        // get the adapter from the recyclerView and submit the list of peers
        val adapter = recyclerView.adapter as PeersRecyclerViewAdapter
        adapter.submitList(peers)
    }
}
