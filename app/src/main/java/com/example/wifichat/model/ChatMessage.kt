package com.example.wifichat.model

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import com.example.wifichat.helpers.DateHelpers
import com.example.wifichat.helpers.upscaleBitmap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

/**
    * Data class to represent a chat message
    * @param author The author of the message
    * @param timestamp The time the message was sent
    * @param message The message content ie. text
    * @param image The image content of the message. The ChatMessage can only have
    * either a message or an image
    * @property formattedTimestamp The formatted date and time of the message
    * @property drawable The drawable representation of the image
    *
 */
@Parcelize
data class ChatMessage(
    val author: String,
    val timestamp: Long,
    val message: String?,
    val image: Bitmap? = null
) :
    Parcelable {
    val formattedTimestamp: String
        get() = DateHelpers.getFormattedDateTime(timestamp)

    @IgnoredOnParcel
    val drawable = MutableLiveData<BitmapDrawable>()

    init {
        // Upscale the image when the ChatMessage is created. Since it is a computation
        // heavy operation perform it in a coroutine
        CoroutineScope(Dispatchers.Default).launch {
            val scaledBitmap = image?.upscaleBitmap(2)
            withContext(Dispatchers.Main) {
                drawable.value = BitmapDrawable(Resources.getSystem(), scaledBitmap)
            }
        }
    }
}
