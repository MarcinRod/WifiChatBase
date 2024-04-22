package com.example.wifichat.broadcastReceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager

/** WfiStateReceiver is a BroadcastReceiver that listens for changes in the Wi-Fi state
 * The WifiStateListener interface is used to notify the listener when the Wi-Fi state changes
 * and perform the appropriate action
 */
class WifiStateReceiver(private val listener: WifiStateListener) : BroadcastReceiver(){
    // Define the interface that the receiver can notify
    interface WifiStateListener {
        fun onWifiEnabled()
        fun onWifiDisabled()
    }

    override fun onReceive(context: Context, intent: Intent) {

    }

}