package com.example.movieapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Movie(
    val id: Int = -1,
    val adult: Boolean = false,
    // val genre_ids: List<Int> = listOf(), Este también va para afuera
    val backdrop_path: String = "",
    val original_title: String = "",
    val original_language: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = -1.0,
    val vote_count: Int = -1,
    val movie_type: String = ""
)


data class MovieList(val results: List<Movie> = listOf())

//Room

@Entity  // este arroba lo podemos usar por la librería KAPT
data class MovieEntity(
    @PrimaryKey   // Señalamos la clave primaria de la tabla
    val id: Int = -1,
    @ColumnInfo (name = "adult")   // Para ponerle nombre a la columna
    val adult: Boolean = false,
    // val genre_ids: List<Int> = listOf(),   NO LA NECESITAMOS, se borra
    @ColumnInfo (name = "backdrop_path")
    val backdrop_path: String = "",
    @ColumnInfo (name = "original_title")
    val original_title: String = "",
    @ColumnInfo (name = "original_language")
    val original_language: String = "",
    @ColumnInfo (name = "overview:")
    val overview: String = "",
    @ColumnInfo (name = "popularity")
    val popularity: Double = -1.0,
    @ColumnInfo (name = "psoter_path")
    val poster_path: String = "",
    @ColumnInfo (name = "release_date")
    val release_date: String = "",
    @ColumnInfo (name = "title")
    val title: String = "",
    @ColumnInfo (name = "video")
    val video: Boolean = false,
    @ColumnInfo (name = "vote_average")
    val vote_average: Double = -1.0,
    @ColumnInfo (name = "vote_count")
    val vote_count: Int = -1,
    @ColumnInfo (name = "movie_type")
    val movie_type: String = ""
)

//Agregamos extension function
fun List<MovieEntity>.toMovieList(): MovieList {
    val resultList = mutableListOf<Movie>()
    this.forEach { movieEntity ->
        resultList.add(movieEntity.toMovie())
    }
    return MovieList(resultList)
}

fun MovieEntity.toMovie(): Movie = Movie(
    this.id,
    this.adult,
    this.backdrop_path,
    this.original_title,
    this.original_language,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    this.movie_type
)

// Agregamos Extension Function
fun Movie.toMovieEntity(movieType: String): MovieEntity = MovieEntity(
    this.id,
    this.adult,
    this.backdrop_path,
    this.original_title,
    this.original_language,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    movie_type = movieType
)