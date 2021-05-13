package com.enesigneci.tmdb.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.enesigneci.tmdb.R
import com.enesigneci.tmdb.databinding.DetailFragmentBinding
import com.enesigneci.tmdb.extensions.toImageUrl
import com.enesigneci.tmdb.extensions.toReleaseDate
import com.enesigneci.tmdb.ui.detail.otherdetails.OtherDetailsAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: DetailFragmentBinding
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.get("movie_id").let {
            viewModel.getMovieDetails(it as Int)
        }


        viewModel.detailLiveData.observe(viewLifecycleOwner, Observer {
            binding.apply {
                movieItem.imageUrl = it.backdropPath?.toImageUrl()
                movieItem.releaseDate = it.releaseDate?.toReleaseDate()
                movieItem.title = it.originalTitle
                movieItem.voteAverage = it.voteAverage?.toFloat()
                it.id?.let {
                    vpDetail.adapter = OtherDetailsAdapter(this@DetailFragment, it)
                }
                TabLayoutMediator(tlDetail, vpDetail) { tab, position ->
                    if (position == 0) {
                        tab.text = getString(R.string.crew)
                    } else {
                        tab.text = getString(R.string.cast)
                    }
                }.attach()
            }
        })

    }

}