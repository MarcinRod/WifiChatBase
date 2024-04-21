package com.example.wifichat

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wifichat.broadcastReceivers.WiFiDirectBroadcastReceiver
import com.example.wifichat.broadcastReceivers.WiFiDirectBroadcastReceiver.*
import com.example.wifichat.broadcastReceivers.WifiStateReceiver
import com.example.wifichat.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

/**
 * Main activity for the app.
 *
 * This activity is responsible for:
 * Checking and requesting permissions required for the app to function properly;
 * setting up  WiFi Direct connection and managing  WiFi state:
 * Listening to changes in:
 * the WiFi state WifiStateReceiver.WifStateListener) and
 * WiFi Direct state (WiFiDirectBroadcastReceiver.WifiDirectStateListener);
 */
class MainActivity : AppCompatActivity(), WifiStateReceiver.WifiStateListener,
    WifiDirectStateListener {
    // View binding variable
    private lateinit var binding: ActivityMainBinding

    // flag to show the snackbar for the WiFi enabled message
    private var showWifiEnabledSnackbar = true


    // Broadcast receiver for the WiFi state broadcasts
    private val wifiStateReceiver: WifiStateReceiver by lazy {
        WifiStateReceiver(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    fun requiredPermissionsGranted(): Boolean {
        // Check if the required dangerous permissions are granted
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            !(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(
                Manifest.permission.NEARBY_WIFI_DEVICES
            ) != PackageManager.PERMISSION_GRANTED)
        } else {
            checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        }
    }

    // Method to handle request permissions result
    // This method is called when the user responds to the permissions request
    // The parameters are the request code, the array of permissions requested,
    // and the array of results for the request
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }


    // Method to intercept the WiFi state change when the WiFi is enabled
    override fun onWifiEnabled() {

    }

    // Method to intercept the WiFi state change when the WiFi is disabled
    override fun onWifiDisabled() {

    }

    // Implementation of the methods of the WifiDirectStateListener interface
    // of the WiFiDirectBroadcastReceiver
    override fun onWifiDirectStateChanged(enabled: Boolean) {
        Log.d("WifiDirect", "State changed: $enabled")
    }

    override fun onThisDeviceChanged(device: WifiP2pDevice?) {
        // Respond to this device's wifi state changing
        Log.d("WifiDirect", "This device changed: $device")
    }
}