package com.enesigneci.tmdb.extensions

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.toReleaseDate(): String{
    val stringDate = SimpleDateFormat("YYYY-MM-DD").parse(this)

    val outputFormat: DateFormat = SimpleDateFormat("MM:YY")

    return outputFormat.format(stringDate).toString()
}