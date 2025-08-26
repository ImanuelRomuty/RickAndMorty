package com.skeleton.rickandmorty.data.remote.datasource

import com.skeleton.rickandmorty.data.remote.response.CharacterResponseDto
import com.skeleton.rickandmorty.data.remote.service.CharacterApiService


class CharacterRemoteDataSourceImpl(
    private val apiService: CharacterApiService
) : CharacterRemoteDataSource {

    override suspend fun getCharacters(page: Int): CharacterResponseDto {
        return apiService.getCharacters(page)
    }
}