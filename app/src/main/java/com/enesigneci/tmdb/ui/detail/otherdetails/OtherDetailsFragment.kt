package com.enesigneci.tmdb.ui.detail.otherdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.enesigneci.tmdb.Constants
import com.enesigneci.tmdb.databinding.OtherDetailsFragmentBinding
import com.enesigneci.tmdb.ui.detail.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtherDetailsFragment: Fragment() {
    private lateinit var binding: OtherDetailsFragmentBinding
    private val viewModel: DetailViewModel by viewModels()
    private var adapter = CastCrewAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = OtherDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            arguments?.getInt(Constants.MOVIE_ID)?.let {
                viewModel.getMovieCredits(it)
                binding.rvDetail.adapter = adapter
                binding.rvDetail.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }

        viewModel.creditsLiveData.observe(viewLifecycleOwner, Observer {
            arguments?.let { bundle ->
                if (bundle.containsKey(Constants.CREW_KEY)) {
                    adapter.setItems(it, Constants.CREW_ORDER)
                } else if (bundle.containsKey(Constants.CAST_KEY)) {
                    adapter.setItems(it, Constants.CAST_ORDER)
                }
                binding.rvDetail.adapter = adapter
                binding.rvDetail.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        })
    }
}
