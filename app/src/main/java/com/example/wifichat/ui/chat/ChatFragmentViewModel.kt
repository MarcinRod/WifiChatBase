package com.example.wifichat.ui.chat

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.wifi.p2p.WifiP2pInfo
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wifichat.broadcastReceivers.WiFiDirectBroadcastReceiver
import com.example.wifichat.model.ChatMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.DataInputStream
import java.io.InputStream
import java.io.OutputStreamWriter
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket
import java.nio.ByteBuffer

class ChatFragmentViewModel : ViewModel(),
    WiFiDirectBroadcastReceiver.WifiDirectConnectionListener {
    // create a live data object to store the state of the chat
    // value is set to false by default meaning the chat is not yet active
    private val _isActive = MutableLiveData(false)
    val isActive: LiveData<Boolean> =
        _isActive  // reference to the mutable data object for data binding purposes

    private val _messages: MutableLiveData<List<ChatMessage>> =
        MutableLiveData() // create an array list to store messages
    val messages: LiveData<List<ChatMessage>> =
        _messages  // reference to the mutable data object for data binding purposes

    private val _status: MutableLiveData<String> =
        MutableLiveData() // create a live data object to store the status message
    val status: LiveData<String> =
        _status // reference to the mutable data object for data binding purposes

    // create a mutable live data object to store the current message input in the edit text field
    // this requires a mutable live data object var object because the value will be updated by the user
    var currentMessage: MutableLiveData<String> = MutableLiveData()

    // A variable to store the name of the author of the messages sent by this device
    private var authorName = ""

    /**
     * Sends the message based on the current message input in the edit text field
     * and updates the list of messages
     */
    fun handleMessage() {

    }

    /**
     * Handles the image provided by the user. It process it and sends it to the connected device
     * @param bitmap The image to handle
     */
    fun handleImage(bitmap: Bitmap) {

    }

    /**
     * Updates the list of messages with the new message or image
     *
     * Note:
     *
     * The ChatMessage can only have either a message or an image.
     * Having both is not supported for now.
     * @param author The author of the message
     * @param message The message content
     * @param image The image content
     */
    private fun updateList(author: String, message: String? = null, image: Bitmap? = null) {

    }

    /**
     * Sets the status of the chat
     * @param info The WifiP2pInfo object containing the connection information
     */
    fun setStatus(info: WifiP2pInfo) {

    }

    /** Show the image in the chat
     * @param author The author of the image
     * @param bitmap The image to show
     */
    private fun showImage(author: String, bitmap: Bitmap) {
        updateList(author = author, image = bitmap)
    }

    /** Show the message in the chat
     * @param author The author of the message
     * @param message The message to show
     */
    private fun showMessage(author: String, message: String) {
        updateList(author, message)
    }

    // Variables related to the connection:
    // The port number used for the connection
    private val port = 8888
    // The server socket used to listen for incoming connections
    private var serverSocket: ServerSocket? = null
    // The client socket used to connect to the other device
    private var socket: Socket? = null
    // The coroutine scope used for the connection tasks
    private val connectionCoroutineScope = CoroutineScope(Dispatchers.IO)
    // The byte array used to read the incoming messages and images
    // 256KB is allocated for the byte array
    private val byteArray = ByteArray(1024 * 256)
    // The capacity of the byte array used to store the size of the image
    private val bitmapSizeByteCapacity = 4

    /**
     * Starts the server to listen for incoming connections.
     * This is a background task that runs in the IO context.
     */
    private fun startServer() {

    }
    /**
     * Starts the client to connect to the server.
     * This is a background task that runs in the IO context.
     * @param groupOwnerAddress The IP address of the group owner
     */
    private fun startClient(groupOwnerAddress: InetAddress?) {

    }

    /**
     * Handles the incoming input stream from the connected device.
     * This is a background task that runs in the IO context.
     * @param author The author of the message
     * @param inputStream The input stream from the connected device
     */
    private suspend fun handleInputStream(author: String, inputStream: InputStream?) {

    }

    /**
     * Sends the message to the connected device.
     * This is a background task that runs in the IO context.
     * @param message The message to send
     */
    private fun sendMessage(message: String) {

    }

    /**
     * Sends the image to the connected device.
     * This is a background task that runs in the IO context.
     * @param bitmapByteArray The byte array of the image to send
     */
    private fun sendImage(bitmapByteArray: ByteArray) {

    }

    // Implement the WifiDirectConnectionListener interface methods
    override fun onWifiDirectInfoAvailable(info: WifiP2pInfo) {
        // This is not used in this class but can be used to handle the connection information
        Log.i("ChatFragmentViewModel", "onWifiDirectInfoAvailable\n${info}")
    }

    override fun onWifiDirectDisconnected() {
        // Update the status message and isActive flag when the connection is lost

    }

    // Override the onCleared method to close the sockets used for communication and
    // cancel the listening background thread
    override fun onCleared() {
        super.onCleared()

    }

}
