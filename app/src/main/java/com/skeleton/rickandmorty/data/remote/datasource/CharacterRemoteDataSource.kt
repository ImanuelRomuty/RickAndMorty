package com.skeleton.rickandmorty.data.remote.datasource

import com.skeleton.rickandmorty.data.remote.response.CharacterResponseDto

interface CharacterRemoteDataSource {
    suspend fun getCharacters(page: Int): CharacterResponseDto
}