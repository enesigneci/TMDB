package com.enesigneci.tmdb.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.enesigneci.tmdb.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.searchLiveData.observe(viewLifecycleOwner, Observer {
            binding.message.text = it?.results?.get(0)?.originalTitle
        })
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer {
            binding.message.text = it.message
        })
        binding.apply {
            message.setOnClickListener {
                viewModel.searchInTMDB("Hababam ")
            }
        }
    }

}