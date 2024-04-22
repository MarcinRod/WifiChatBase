package com.example.wifichat.ui.chat

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Bitmap
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wifichat.MainActivity
import com.example.wifichat.R
import com.example.wifichat.databinding.FragmentChatBinding
import com.example.wifichat.helpers.upscaleBitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Fragment for the chat screen
 * Displays the chat messages and allows the user to send messages and images
 */
@SuppressLint("MissingPermission")
class ChatFragment : Fragment() {
    // The binding object for the fragment
    private lateinit var binding: FragmentChatBinding

    // The arguments passed to the fragment - contains the WifiDirectInfo object
    // used to setup the socket connection
    private val args: ChatFragmentArgs by navArgs()

    // The ViewModel for the fragment
    private val chatFragmentViewModel: ChatFragmentViewModel by lazy {
        ViewModelProvider(this)[ChatFragmentViewModel::class.java]
    }

    // The adapter for the RecyclerView displaying the chat messages
    private val chatAdapter = ChatMessageRecyclerViewAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        //Initialize the binding object and the ViewModel
        binding = FragmentChatBinding.inflate(inflater, container, false)
        binding.viewModel = chatFragmentViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        // Setup the RecyclerView and the buttons
        setupRecyclerView()
        setupButtons()

        // Set the listeners for the WifiDirectBroadcastReceiver
        // to handle the connection changes
        setupWifiDirectListeners()

        // Show the initial status of the connection and set the current user name
        showStatus()
        return binding.root
    }


    /**
     * Sets up the buttons in the chat window
     * The send button sends the message in the text field
     * The add photo button opens the camera to take a picture
     */
    private fun setupButtons() {
        binding.msgSendButton.setOnClickListener {

        }
        binding.addPhotoButton.setOnClickListener {

        }
    }

    /**
     * Sets up the RecyclerView for the chat messages
     */
    private fun setupRecyclerView() {
        with(binding.messageList) {
            layoutManager = LinearLayoutManager(context)
            adapter = chatAdapter

        }
    }

    /**
     * Sets up the listeners for the WifiDirectBroadcastReceiver
     * to handle the connection changes
     */
    private fun setupWifiDirectListeners() {

    }

    /**
     * Shows the status of the connection in the chat window
     * and the current user name
     */
    private fun showStatus() {

    }

    /**
     * Shows a dialog with the image preview and the option to send the image
     * @param bitmap The bitmap to display in the dialog
     */
    @SuppressLint("MissingInflatedId", "InflateParams")
    private fun showImageDialog(bitmap: Bitmap) {

    }


    // Disconnect the devices by removing the group and canceling the connection
    // each time the fragment is destroyed
    override fun onDestroy() {
        super.onDestroy()
    }
}