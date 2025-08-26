package com.skeleton.rickandmorty.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.skeleton.rickandmorty.data.mapper.toDomain
import com.skeleton.rickandmorty.domain.model.Karakter
import com.skeleton.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCharactersUseCase(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<PagingData<Karakter>> {
        return repository.getCharacters()
            .map { pagingData ->
                pagingData.map { entity ->
                    entity.toDomain()
                }
            }
    }

    fun searchCharacters(query: String): Flow<PagingData<Karakter>> {
        return repository.searchCharacters(query)
    }
}
