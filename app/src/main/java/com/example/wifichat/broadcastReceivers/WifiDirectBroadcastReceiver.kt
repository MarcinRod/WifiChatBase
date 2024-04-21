package com.example.wifichat.broadcastReceivers

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pDeviceList
import android.net.wifi.p2p.WifiP2pInfo
import android.net.wifi.p2p.WifiP2pManager
import android.util.Log

/**
 * A BroadcastReceiver that notifies of important Wi-Fi p2p events.
 * This class is used to notify the activity of changes in the Wi-Fi Direct state,
 * the list of peers, and the connection status.
 */
// Suppress the missing permission warning - the permissions are checked in the MainActivity which
// is the only place where this receiver is registered
@SuppressLint("MissingPermission")
class WiFiDirectBroadcastReceiver(
    private val manager: WifiP2pManager,
    private val channel: WifiP2pManager.Channel,
) : BroadcastReceiver() {
    // Define the different interfaces that the receiver can notify
    interface WifiDirectStateListener {
        // Interface used when the Wi-Fi Direct state changes
        fun onWifiDirectStateChanged(enabled: Boolean)
        fun onThisDeviceChanged(device: WifiP2pDevice?)
    }

    interface WifiDirectPeersListener {
        // Interface to notify the listener when the list of peers changes
        fun onPeersAvailable(deviceList: WifiP2pDeviceList)
    }

    interface WifiDirectConnectionListener {
        // Interface to notify the listener when the connection changes
        fun onWifiDirectInfoAvailable(info: WifiP2pInfo)
        fun onWifiDirectDisconnected()
    }

    // Listeners and their setters
    private var stateListener: WifiDirectStateListener? = null
    fun setWifiDirectStateListener(listener: WifiDirectStateListener) {
        this.stateListener = listener
    }

    private var peersListener: WifiDirectPeersListener? = null
    fun setWifiDirectPeersListener(listener: WifiDirectPeersListener) {
        this.peersListener = listener
    }

    private var connectionListener: WifiDirectConnectionListener? = null
    fun setWifiDirectConnectionListener(listener: WifiDirectConnectionListener) {
        this.connectionListener = listener
    }

    // Handle the different actions that the receiver can receive
    @Suppress("DEPRECATION")
    override fun onReceive(context: Context, intent: Intent) {
        val action: String? = intent.action
        //------------------------------------------------------------------------------------------
        // Log the action and the extras - for debugging purposes only
        val stringBuild = StringBuilder()
        intent.extras?.keySet()?.forEach { key ->
            stringBuild.append("$key: ${intent.extras?.get(key)}\n")
        }
        Log.i("WiFiDirectBroadcastReceiver", "onReceive: $action\n$stringBuild")
        //------------------------------------------------------------------------------------------
        // Handle the different actions
        when (action) {

        }
    }
}

