package com.skeleton.rickandmorty.data.repository


import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.skeleton.rickandmorty.data.local.AppDatabase
import com.skeleton.rickandmorty.data.local.datasource.CharacterLocalDataSource
import com.skeleton.rickandmorty.data.local.entity.CharacterEntity
import com.skeleton.rickandmorty.data.remote.datasource.CharacterRemoteDataSource
import com.skeleton.rickandmorty.data.mapper.toDomain
import com.skeleton.rickandmorty.data.mediator.CharacterRemoteMediator
import com.skeleton.rickandmorty.domain.repository.CharacterRepository
import com.skeleton.rickandmorty.domain.model.Karakter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

import androidx.paging.map

class CharacterRepositoryImpl(
    private val localDataSource: CharacterLocalDataSource,
    private val remoteDataSource: CharacterRemoteDataSource,
    private val database: AppDatabase
) : CharacterRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getCharacters(): Flow<PagingData<CharacterEntity>> {
        val pagingSourceFactory = { localDataSource.getAllCharacters() }

        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = CharacterRemoteMediator(
                database = database,
                remoteDataSource = remoteDataSource
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchCharacters(query: String): Flow<PagingData<Karakter>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { localDataSource.searchCharacters(query) }
        ).flow.map { data -> data.map { it.toDomain() } }
    }

}
