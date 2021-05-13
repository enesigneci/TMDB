package com.enesigneci.tmdb.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enesigneci.tmdb.network.TMDBService
import com.enesigneci.tmdb.network.model.MovieCreditsResponse
import com.enesigneci.tmdb.network.model.MovieDetailResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val service: TMDBService) : ViewModel() {
    var detailLiveData = MutableLiveData<MovieDetailResponse>()
    var errorLiveData = MutableLiveData<Throwable>()

    var creditsLiveData = MutableLiveData<MovieCreditsResponse>()
    fun getMovieDetails(movieId: Int) {
        service.getMovieDetails(movieId = movieId).enqueue(object: Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                detailLiveData.value = response.body()
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                errorLiveData.value = t
            }

        })
    }

    fun getMovieCredits(movieId: Int) {
        service.getMovieCredits(movieId = movieId).enqueue(object: Callback<MovieCreditsResponse> {
            override fun onResponse(
                call: Call<MovieCreditsResponse>,
                response: Response<MovieCreditsResponse>
            ) {
                creditsLiveData.value = response.body()
            }

            override fun onFailure(call: Call<MovieCreditsResponse>, t: Throwable) {
                errorLiveData.value = t
            }

        })
    }
}