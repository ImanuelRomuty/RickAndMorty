package com.skeleton.rickandmorty.data.local.datasource

import androidx.paging.PagingSource
import com.skeleton.rickandmorty.data.local.dao.CharacterDao
import com.skeleton.rickandmorty.data.local.entity.CharacterEntity

class CharacterLocalDataSourceImpl(
    private val characterDao: CharacterDao
) : CharacterLocalDataSource {

    override fun getAllCharacters(): PagingSource<Int, CharacterEntity> {
        return characterDao.getAllCharacters()
    }

    override suspend fun insertCharacters(characters: List<CharacterEntity>) {
        characterDao.insertCharacters(characters)
    }
    override fun searchCharacters(query: String)=characterDao.searchCharacters(query)


    override suspend fun clearCharacters() {
        characterDao.clearCharacters()
    }
}
