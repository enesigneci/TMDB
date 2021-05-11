package com.enesigneci.tmdb.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enesigneci.tmdb.network.TMDBService
import com.enesigneci.tmdb.network.model.SearchResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val service: TMDBService) : ViewModel() {
    var searchLiveData = MutableLiveData<SearchResponse>()
    var errorLiveData = MutableLiveData<Throwable>()
    fun searchInTMDB(searchTerm: String) {
        service.searchInAPI(searchTerm = searchTerm).enqueue(object: Callback<SearchResponse>{
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                searchLiveData.value = response.body()
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                errorLiveData.value = t
            }

        })
    }
}