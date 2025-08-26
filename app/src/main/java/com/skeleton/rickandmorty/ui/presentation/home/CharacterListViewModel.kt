package com.skeleton.rickandmorty.ui.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.skeleton.rickandmorty.domain.model.Karakter
import com.skeleton.rickandmorty.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn

class CharacterListViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _searchParams = MutableStateFlow(SearchParams("", null))
    val searchParams: StateFlow<SearchParams> = _searchParams

    val characters: StateFlow<PagingData<Karakter>> = _searchParams
        .flatMapLatest { params ->
            if (params.query.isBlank() && params.status.isNullOrBlank()) {
                getCharactersUseCase()
            } else {
                getCharactersUseCase.searchCharacters(params.query)
            }
        }
        .cachedIn(viewModelScope)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = PagingData.empty()
        )

    fun searchCharacters(query: String, status: String? = null) {
        _searchParams.value = SearchParams(query, status)
    }
}

data class SearchParams(val query: String, val status: String?)
