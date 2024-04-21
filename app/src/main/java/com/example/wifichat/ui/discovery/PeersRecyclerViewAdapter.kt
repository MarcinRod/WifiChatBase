package com.example.wifichat.ui.discovery

import android.net.wifi.p2p.WifiP2pDevice
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wifichat.databinding.PeerViewHolderBinding

import com.example.wifichat.helpers.getStatus


class PeersRecyclerViewAdapter :
    ListAdapter<WifiP2pDevice, PeersRecyclerViewAdapter.ViewHolder>(Comparator) {
    // An object used to determine if two items represent the same WifiP2pDevice object
    object Comparator : DiffUtil.ItemCallback<WifiP2pDevice>() {
        override fun areItemsTheSame(oldItem: WifiP2pDevice, newItem: WifiP2pDevice): Boolean {
            return oldItem === newItem
        }

        // An object used to determine if two items have the same contents
        override fun areContentsTheSame(oldItem: WifiP2pDevice, newItem: WifiP2pDevice): Boolean {
               return oldItem.deviceAddress == newItem.deviceAddress
        }
    }
    // An interface for handling item clicks
    interface OnItemClickListener {
        fun onItemClick(peer: WifiP2pDevice)
    }
    // A listener for handling item clicks
    private var onItemClickListener: OnItemClickListener? = null
    /**
     * Sets the listener for handling item clicks
     * @param listener The listener for handling item clicks
     */
    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    // Creates a new ViewHolder object for displaying items in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the view using the PeerViewHolderBinding object
        return ViewHolder(
            PeerViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // Binds a WifiP2pDevice object to a ViewHolder object
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the WifiP2pDevice object at the specified position in the list of items
        val item = getItem(position)
        // Bind the WifiP2pDevice object to the ViewHolder object
        holder.bind(item)
    }

    // A ViewHolder object for displaying a single WifiP2pDevice object
    inner class ViewHolder(private val binding: PeerViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {


        // Binds a WifiP2pDevice object to the ViewHolder object
        fun bind(peer: WifiP2pDevice) {
            // Set the peer variable in the layout
            binding.peer = peer
            // Set the status variable in the layout
            binding.status = peer.getStatus(resources = binding.root.context.resources)
            // Set the click listener for the layout
            binding.root.setOnClickListener {
                onItemClickListener?.onItemClick(peer)
            }
            // Execute any pending bindings
            binding.executePendingBindings()
        }

    }
}
