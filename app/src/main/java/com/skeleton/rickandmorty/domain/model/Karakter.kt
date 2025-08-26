package com.skeleton.rickandmorty.domain.model

data class Karakter(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: String,
    val location: String,
    val image: String,


    val episode: List<String>,
    val url: String,
    val created: String


)