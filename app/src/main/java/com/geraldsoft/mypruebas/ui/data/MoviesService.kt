package com.geraldsoft.mypruebas.ui.data

import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService {

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun fetchPopularMovies(): RemoteResult

    @GET("movie/{id}")
    suspend fun fetchMovieById(@Path("id") id: Int): RemoteMovie

}