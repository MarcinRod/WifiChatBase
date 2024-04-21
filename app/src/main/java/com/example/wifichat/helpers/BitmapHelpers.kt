package com.example.wifichat.helpers

import android.graphics.Bitmap

/**
 * Upscale the bitmap by the given scale factor
 * @param scale The scale factor to upscale the bitmap by
 * @return The upscaled bitmap
 */
@Suppress("RedundantSuspendModifier")
suspend fun Bitmap.upscaleBitmap(scale:Int): Bitmap {
    val newWidth = this.width * scale // upscale the width
    val newHeight = this.height * scale // upscale the height
    // create a new bitmap with the new dimensions - the filter is set to true to enable bilinear filtering
    // which smooths the image (but is slower), if the filter is set to false the nearest
    // neighbor scaling is used which is faster but the image is more pixelated
    return Bitmap.createScaledBitmap(this, newWidth, newHeight, true)
}