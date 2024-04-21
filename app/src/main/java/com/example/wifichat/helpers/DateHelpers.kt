package com.example.wifichat.helpers

import java.text.DateFormat
import java.util.Locale
/*
 * Helper class to format dates
 */
class DateHelpers {
    companion object {
        /**
         * Get the formatted date from time since epoch in long format
         * @param date The date in long  format
         * @return The formatted date in SHORT format
         */
        fun getFormattedDate(date: Long): String {
            // Get the date format in SHORT form for the default locale of the device
            val dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault())
            // Format the date and return it
            return dateFormat.format(date)
        }
        /**
         * Get the formatted date and time from time since epoch in long format
         * @param dateTime The date and time in long format
         * @return The formatted date and time in SHORT format
         */
        fun getFormattedDateTime(dateTime: Long): String {
            // Get the date and time format in SHORT form for the default locale of the device
            val dateTimeFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT,
                Locale.getDefault()
            )
            // Format the date and time and return it
            return dateTimeFormat.format(dateTime)
        }
    }
}