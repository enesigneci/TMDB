package com.enesigneci.tmdb.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enesigneci.tmdb.databinding.SearchItemLayoutBinding
import com.enesigneci.tmdb.extensions.toReleaseDate
import com.enesigneci.tmdb.network.model.SearchResponse

class SearchAdapter: RecyclerView.Adapter<SearchAdapter.SearchItemViewHolder>() {
    var result = SearchResponse()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
        val itemBinding = SearchItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        result.results?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount() = result.results?.size ?: 0

    inner class SearchItemViewHolder(private val itemBinding: SearchItemLayoutBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(result: SearchResponse.Result) {
            itemBinding.movieItem.imageUrl = "https://image.tmdb.org/t/p/original/${result.posterPath.toString()}"
            itemBinding.movieItem.releaseDate = result.releaseDate?.toReleaseDate()
            itemBinding.movieItem.title = result.title
            itemBinding.movieItem.voteAverage = result.voteAverage?.toFloat()
        }
    }
    fun setSearchResponse(searchResponse: SearchResponse) {
        result = searchResponse
        notifyDataSetChanged()
    }
}