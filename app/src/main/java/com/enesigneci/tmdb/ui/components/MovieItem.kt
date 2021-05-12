package com.enesigneci.tmdb.ui.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.enesigneci.tmdb.R
import com.enesigneci.tmdb.databinding.ComponentMovieItemLayoutBinding
import com.enesigneci.tmdb.extensions.loadImageFromUrl


class MovieItem @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, @AttrRes defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var _imageUrl: String? = null
    private var _voteAverage: Float? = null
    private var _title: String? = null
    private var _releaseDate: String? = null
    private lateinit var binding: ComponentMovieItemLayoutBinding


    var imageUrl: String?
        get() = _imageUrl
        set(value) {
            _imageUrl = value
            value?.let { binding.ivMoviePoster.loadImageFromUrl(it) }
            invalidate()
        }

    var voteAverage: Float?
        get() = _voteAverage
        set(value) {
            _voteAverage = value
            binding.tvVoteAverage.text = value.toString()
            invalidate()
        }
    var title: String?
        get() = _title
        set(value) {
            _title = value
            binding.tvTitle.text = value
            invalidate()
        }
    var releaseDate: String?
        get() = _releaseDate
        set(value) {
            _releaseDate = value
            binding.tvReleaseDate.text = value
            invalidate()
        }



    private fun init(attrs: AttributeSet?, defStyle: Int) {
        binding = ComponentMovieItemLayoutBinding.inflate(LayoutInflater.from(context), this, true)
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.MovieItem, defStyle, 0
        )

        _imageUrl = a.getString(
            R.styleable.MovieItem_imageUrl
        )

        _title = a.getString(
            R.styleable.MovieItem_title
        )
        _voteAverage = a.getFloat(
            R.styleable.MovieItem_voteAverage, 0f
        )
        _releaseDate = a.getString(
            R.styleable.MovieItem_releaseDate
        )

    }
    init {
        init(attrs, defStyleAttr)
    }
}