package com.enesigneci.tmdb.extensions

import java.lang.Exception
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.toReleaseDate(): String{
    try {
        val stringDate = SimpleDateFormat("YYYY-MM-DD").parse(this)

        val outputFormat: DateFormat = SimpleDateFormat("MM:YY")

        return outputFormat.format(stringDate).toString()
    } catch (exception: Exception) {
        return this
    }
}