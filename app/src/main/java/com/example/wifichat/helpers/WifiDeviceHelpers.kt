package com.example.wifichat.helpers

import android.content.res.Resources
import android.net.wifi.p2p.WifiP2pDevice
import com.example.wifichat.R

/**
 * Extension function for WifiP2pDevice.
 * @param resources The resources object used to get the string
 * @return a string representation of the status of a WifiP2pDevice object
 */
fun WifiP2pDevice.getStatus(resources: Resources): String {
    return when (status) {
        WifiP2pDevice.CONNECTED -> resources.getString(R.string.connected_status)
        WifiP2pDevice.INVITED -> resources.getString(R.string.invited_status)
        WifiP2pDevice.FAILED -> resources.getString(R.string.failed_status)
        WifiP2pDevice.AVAILABLE -> resources.getString(R.string.available_status)
        WifiP2pDevice.UNAVAILABLE -> resources.getString(R.string.unavailable_status)
        else -> resources.getString(R.string.unknown_status)
    }
}