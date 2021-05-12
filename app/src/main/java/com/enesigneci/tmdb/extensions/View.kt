package com.enesigneci.tmdb.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.enesigneci.tmdb.R

fun ImageView.loadImageFromUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .placeholder(R.drawable.poster_placeholder)
        .into(this)
}