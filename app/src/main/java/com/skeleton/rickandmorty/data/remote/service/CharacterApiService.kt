package com.skeleton.rickandmorty.data.remote.service

import com.skeleton.rickandmorty.data.remote.response.CharacterResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {
    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int = 1
    ): CharacterResponseDto
}