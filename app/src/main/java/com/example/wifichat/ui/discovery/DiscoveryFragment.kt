package com.example.wifichat.ui.discovery

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.ColorDrawable
import android.net.wifi.p2p.WifiP2pConfig
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pDeviceList
import android.net.wifi.p2p.WifiP2pInfo
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wifichat.MainActivity
import com.example.wifichat.R
import com.example.wifichat.broadcastReceivers.WiFiDirectBroadcastReceiver
import com.example.wifichat.databinding.FragmentDiscoveryBinding
import com.google.android.material.snackbar.Snackbar

/**
 *  Fragment for discovering peers and connecting to them
 *  It is responsible for
 *  - starting and stopping the discovery of peers,
 *  - displaying the list of available peers,
 *  - connecting to a selected peer.
 */
@SuppressLint("MissingPermission") // Permission checks are done in the MainActivity
class DiscoveryFragment : Fragment(), WiFiDirectBroadcastReceiver.WifiDirectPeersListener,
    WiFiDirectBroadcastReceiver.WifiDirectConnectionListener {
    // Lazy initialization of the view model for the fragment
    private val discoveryFragmentViewModel: DiscoveryFragmentViewModel by lazy {
        DiscoveryFragmentViewModel()
    }

    // Binding object for the fragment
    private lateinit var binding: FragmentDiscoveryBinding

    // Dialog for displaying the progress of the discovery process
    private var loadingDialog: AlertDialog? = null

    // Adapter for the RecyclerView
    private val peersAdapter = PeersRecyclerViewAdapter()

    // Reference to the host activity used to access WifiP2pManager, its Channel and registered
    // BroadcastReceiver required for the discovery process
    private val hostActivity by lazy { activity as MainActivity }

    // Flag used to indicate whether listeners have been set for the WifiDirectBroadcastReceiver
    private var wifiIsSetup = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        // Initialize the binding object and and the view model
        binding = FragmentDiscoveryBinding.inflate(inflater, container, false)
        binding.viewModel = discoveryFragmentViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        // reset the view to clear the list of peers -
        // the list is updated when peers are discovered
        resetView()

        // Setup the buttons and the recyclerView
        setupRecyclerView()
        setupButtons()
        return binding.root
    }

    /**
     * Reset the view of the Fragment
     */
    private fun resetView() {
        wifiIsSetup = false
        discoveryFragmentViewModel.reset()
    }

    /**
     * Set up the WifiDirectPeersListener and WifiDirectConnectionListener
     */
    private fun setupWifiDirectListeners() {

    }

    /**
     * Set up the buttons for starting and stopping the discovery process
     */
    private fun setupButtons() {
        binding.discoverButton.setOnClickListener {

        }
        binding.stopDiscoverButton.setOnClickListener {

        }
    }

    /**
     * Set up the RecyclerView for displaying the list of available peers and responding to clicks
     * on the items in the list
     */
    private fun setupRecyclerView() {
        with(binding.messageList) {
            layoutManager = LinearLayoutManager(context)
            peersAdapter.setOnItemClickListener(object :
                PeersRecyclerViewAdapter.OnItemClickListener {
                override fun onItemClick(peer: WifiP2pDevice) {

                }
            })
            adapter = peersAdapter
        }
    }

    /*
    * Start the discovery process
     */
    private fun startDiscovery() {

    }

    /**
     * Stop the discovery process
     */
    private fun stopDiscovery() {

    }

    /**
     * Start/Stops the animation of the discovery icon
     */
    private fun toggleDiscoveryIcon(on: Boolean) {

    }

    /**
     * Show a custom progress dialog with a given message
     * @param progressMsg The message to be displayed in the dialog
     */
    private fun showLoadingDialog(progressMsg: String) {
        // Inflate the custom progress dialog layout - it consists of a TextView and a ProgressBar
        val dialogView = layoutInflater.inflate(R.layout.progress_dialog, null).apply {
            // Set the message to be displayed in the dialog
            findViewById<TextView>(R.id.progress_msg).text = progressMsg
        }
        // Create the dialog with the custom layout
        loadingDialog = AlertDialog.Builder(requireContext()).setView(dialogView).create()
        // Make the background of the dialog transparent
        loadingDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        // Show the dialog
        loadingDialog?.show()
    }

    /**
     * Handle the discovery of peers
     * @param deviceList The list of available peers
     */
    override fun onPeersAvailable(deviceList: WifiP2pDeviceList) {

    }

    /**
     * Connect to a selected peer
     * @param peer The selected peer
     */
    private fun connectToPeer(peer: WifiP2pDevice?) {

    }

    /**
     * Handle the connection to a peer - called when the connection is established
     * @param info The WifiP2pInfo object containing information about the connection
     */
    override fun onWifiDirectInfoAvailable(info: WifiP2pInfo) {

    }

    /*
     * Handle the disconnection from a peer - called when the connection is lost
     */
    override fun onWifiDirectDisconnected() {
        Log.i("DiscoveryFragment", "onWifiDirectDisconnected")

    }

}