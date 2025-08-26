package com.skeleton.rickandmorty.di

import androidx.room.Room
import com.skeleton.rickandmorty.data.local.AppDatabase
import com.skeleton.rickandmorty.data.local.datasource.CharacterLocalDataSource
import com.skeleton.rickandmorty.data.local.datasource.CharacterLocalDataSourceImpl
import com.skeleton.rickandmorty.data.remote.datasource.CharacterRemoteDataSource
import com.skeleton.rickandmorty.data.remote.datasource.CharacterRemoteDataSourceImpl
import com.skeleton.rickandmorty.data.remote.service.CharacterApiService
import com.skeleton.rickandmorty.data.repository.CharacterRepositoryImpl
import com.skeleton.rickandmorty.domain.repository.CharacterRepository
import com.skeleton.rickandmorty.domain.usecase.GetCharactersUseCase
import com.skeleton.rickandmorty.ui.presentation.home.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    // Retrofit
    single {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterApiService::class.java)
    }
    // Database
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "rickmorty.db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    // DAO
    single { get<AppDatabase>().characterDao() }

    // RemoteDataSource
    single<CharacterRemoteDataSource> { CharacterRemoteDataSourceImpl(get()) }
    single<CharacterLocalDataSource> { CharacterLocalDataSourceImpl(get()) }


    // Repository
    single<CharacterRepository> { CharacterRepositoryImpl(get(),get(),get()) }

    // UseCase
    factory { GetCharactersUseCase(get()) }

    //ViewModel
    viewModel { CharacterListViewModel(get()) }

}