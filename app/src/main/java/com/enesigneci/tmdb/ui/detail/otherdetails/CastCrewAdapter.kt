package com.enesigneci.tmdb.ui.detail.otherdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enesigneci.tmdb.databinding.ItemCastCrewLayoutBinding
import com.enesigneci.tmdb.network.model.MovieCreditsResponse

class CastCrewAdapter(): RecyclerView.Adapter<CastCrewAdapter.CastCrewViewHolder>() {
    private var response: MovieCreditsResponse = MovieCreditsResponse()
    private var type: Int = 0
    class CastCrewViewHolder(var itemBinding: ItemCastCrewLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastCrewViewHolder {
        val itemBinding = ItemCastCrewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CastCrewViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CastCrewViewHolder, position: Int) {
        if (type == 0) {
            holder.itemBinding.tvCharacter.text = response.crew?.get(position)?.job
            holder.itemBinding.tvName.text = response.crew?.get(position)?.name
        } else {
            holder.itemBinding.tvCharacter.text = response.cast?.get(position)?.character
            holder.itemBinding.tvName.text = response.cast?.get(position)?.name
        }
    }
    override fun getItemCount(): Int = if (type == 0) {
        response.crew?.size ?: 0
    } else {
        response.cast?.size ?: 0
    }

    fun setItems(response: MovieCreditsResponse, type: Int) {
        this.response = response
        this.type = type
        notifyDataSetChanged()
    }
}