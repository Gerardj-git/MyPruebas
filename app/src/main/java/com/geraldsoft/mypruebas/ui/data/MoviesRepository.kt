package com.geraldsoft.mypruebas.ui.data

class MoviesRepository {

    suspend fun fetchPopularMovies(): List<Movies> =
        MoviesClient
            .intance
            .fetchPopularMovies()
            .results
            .map{
                it.toDomainModel()
            }

    suspend fun findMovieById(id: Int): Movies =
        MoviesClient
            .intance
            .fetchMovieById(id)
            .toDomainModel()

}

private fun RemoteMovie.toDomainModel(): Movies =
    Movies(
        id = id,
        title = title,
        poster =  "https://image.tmdb.org/t/p/w185/$posterPath"
    )