package com.enesigneci.tmdb.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enesigneci.tmdb.Constants
import com.enesigneci.tmdb.R
import com.enesigneci.tmdb.databinding.MainFragmentBinding
import com.enesigneci.tmdb.network.model.SearchResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: MainFragmentBinding
    private var searchAdapter = SearchAdapter()
    private var totalResults = 0
    private var pageCount = 1
    private var movieList = arrayListOf<SearchResponse.Result>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            tiSearch.editText?.doAfterTextChanged {
                if(it.toString().length > 2) {
                    pageCount = 1
                    movieList.clear()
                    viewModel.searchInTMDB(it.toString(), pageCount)
                }
            }
            rvSearchResults.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (rvSearchResults.canScrollVertically(-1) && movieList.size < totalResults) {
                        viewModel.searchInTMDB(tiSearch.editText?.text.toString(), pageCount++)
                    }
                }
            })
            rvSearchResults.adapter = searchAdapter
            rvSearchResults.setHasFixedSize(true)
            rvSearchResults.layoutManager = GridLayoutManager(context, 2)
        }

        searchAdapter.onMovieItemClicked = {
            findNavController().navigate(R.id.action_global_to_detailFragment, bundleOf(Constants.MOVIE_ID to it))
        }

        viewModel.searchLiveData.observe(viewLifecycleOwner, Observer { searchResponse ->
            searchResponse.totalResults?.let {
                totalResults = it
            }

            searchAdapter.setSearchResponse(movieList)
            movieList.addAll((searchResponse.results as ArrayList<SearchResponse.Result>).minus(movieList))
        })
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
        })
    }

}