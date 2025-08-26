package com.skeleton.rickandmorty.data.local.datasource

import androidx.paging.PagingSource
import com.skeleton.rickandmorty.data.local.entity.CharacterEntity

interface CharacterLocalDataSource {
    fun getAllCharacters(): PagingSource<Int, CharacterEntity>
    suspend fun insertCharacters(characters: List<CharacterEntity>)
    fun searchCharacters(query: String): PagingSource<Int, CharacterEntity>
    suspend fun clearCharacters()
}
