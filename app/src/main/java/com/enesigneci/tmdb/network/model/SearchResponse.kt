package com.enesigneci.tmdb.network.model


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var results: List<Result?>? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("total_results")
    var totalResults: Int? = null
) {
    data class Result(
        @SerializedName("adult")
        var adult: Boolean? = null,
        @SerializedName("backdrop_path")
        var backdropPath: Any? = null,
        @SerializedName("first_air_date")
        var firstAirDate: String? = null,
        @SerializedName("genre_ids")
        var genreIds: List<Int?>? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("known_for")
        var knownFor: List<KnownFor?>? = null,
        @SerializedName("media_type")
        var mediaType: String? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("origin_country")
        var originCountry: List<String?>? = null,
        @SerializedName("original_language")
        var originalLanguage: String? = null,
        @SerializedName("original_name")
        var originalName: String? = null,
        @SerializedName("original_title")
        var originalTitle: String? = null,
        @SerializedName("overview")
        var overview: String? = null,
        @SerializedName("popularity")
        var popularity: Double? = null,
        @SerializedName("poster_path")
        var posterPath: Any? = null,
        @SerializedName("profile_path")
        var profilePath: String? = null,
        @SerializedName("release_date")
        var releaseDate: String? = null,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("video")
        var video: Boolean? = null,
        @SerializedName("vote_average")
        var voteAverage: Double? = null,
        @SerializedName("vote_count")
        var voteCount: Int? = null
    ) {
        data class KnownFor(
            @SerializedName("adult")
            var adult: Boolean? = null,
            @SerializedName("backdrop_path")
            var backdropPath: String? = null,
            @SerializedName("first_air_date")
            var firstAirDate: String? = null,
            @SerializedName("genre_ids")
            var genreIds: List<Int?>? = null,
            @SerializedName("id")
            var id: Int? = null,
            @SerializedName("media_type")
            var mediaType: String? = null,
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("origin_country")
            var originCountry: List<String?>? = null,
            @SerializedName("original_language")
            var originalLanguage: String? = null,
            @SerializedName("original_name")
            var originalName: String? = null,
            @SerializedName("original_title")
            var originalTitle: String? = null,
            @SerializedName("overview")
            var overview: String? = null,
            @SerializedName("popularity")
            var popularity: Double? = null,
            @SerializedName("poster_path")
            var posterPath: String? = null,
            @SerializedName("release_date")
            var releaseDate: String? = null,
            @SerializedName("title")
            var title: String? = null,
            @SerializedName("video")
            var video: Boolean? = null,
            @SerializedName("vote_average")
            var voteAverage: Double? = null,
            @SerializedName("vote_count")
            var voteCount: Int? = null
        )
    }
}