package com.enesigneci.tmdb.ui.detail.otherdetails

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.enesigneci.tmdb.Constants

class OtherDetailsAdapter(fragment: Fragment, var movieId: Int) : FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment = OtherDetailsFragment()
        fragment.arguments = Bundle().apply {
            putInt(Constants.MOVIE_ID, movieId)
            if (position == Constants.CREW_ORDER) {
                putAll(bundleOf(Constants.CREW_KEY to "crew"))
            } else if (position == Constants.CAST_ORDER) {
                putAll(bundleOf(Constants.CAST_KEY to "cast"))
            }
        }
        return fragment
    }
}