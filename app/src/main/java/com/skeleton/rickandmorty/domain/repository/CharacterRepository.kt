package com.skeleton.rickandmorty.domain.repository

import androidx.paging.PagingData
import com.skeleton.rickandmorty.data.local.entity.CharacterEntity
import com.skeleton.rickandmorty.domain.model.Karakter
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun searchCharacters(query: String): Flow<PagingData<Karakter>>


    fun getCharacters(): Flow<PagingData<CharacterEntity>>
}