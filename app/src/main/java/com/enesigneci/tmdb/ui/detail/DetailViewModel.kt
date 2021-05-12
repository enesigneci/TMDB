package com.enesigneci.tmdb.ui.detail

import androidx.lifecycle.ViewModel
import com.enesigneci.tmdb.network.TMDBService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val service: TMDBService) : ViewModel() {
    fun getMovieDetails(movieId: Int) {
        service.getMovieDetails(movieId = movieId)
    }
}