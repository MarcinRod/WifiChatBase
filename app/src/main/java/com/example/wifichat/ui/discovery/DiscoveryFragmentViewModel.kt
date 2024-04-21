package com.example.wifichat.ui.discovery

import android.net.wifi.p2p.WifiP2pDevice
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*
 * ViewModel for the DiscoveryFragment.
 * This ViewModel is used to store the state of the discovery process.
 * It stores the list of peers, the status of the discovery process, and whether the discovery process is active.
 */
class DiscoveryFragmentViewModel: ViewModel(){

    // create a live data object to store the state of the discovery process
    private val _discoveryIsActive = MutableLiveData(false)
    val discoveryIsActive: LiveData<Boolean> =
        _discoveryIsActive // reference to the mutable data object for data binding purposes

    // create an array list to store peers - mutable data
    private val _peers: MutableLiveData<List<WifiP2pDevice>> = MutableLiveData()
    val peers: LiveData<List<WifiP2pDevice>> =
        _peers // reference to the mutable data object for data binding purposes

    /**
     * Updates the list of peers from the discovery process.
     * @param deviceList The list of peers discovered during the discovery process
     */
    fun updatePeers(deviceList: Collection<WifiP2pDevice>) {

    }

    /**
     * Clears the list of peers.
     */
    fun clearPeers() {

    }
    /**
     * Sets the discoveryIsActive flag to the specified value.
     */
    fun activateDiscovery(enable: Boolean) {

    }

    /**
     * Clears the view model variables.
     */
    private fun clear(){

    }
    /**
     * Resets the view model.
     */
    fun reset() {clear()
    }
    // Override the onCleared method to clear the view model variables when it's is destroyed
    override fun onCleared() {
        super.onCleared()
    }
}

