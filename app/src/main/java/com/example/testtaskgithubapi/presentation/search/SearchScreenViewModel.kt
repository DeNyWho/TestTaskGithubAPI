package com.example.testtaskgithubapi.presentation.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskgithubapi.core.wrapper.Event
import com.example.testtaskgithubapi.domain.use_cases.search.SearchContentUseCase
import com.example.testtaskgithubapi.presentation.search.state.ContentSearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchContentUseCase
): ViewModel() {


    private val _contentSearchState: MutableState<ContentSearchState> =
        mutableStateOf(ContentSearchState())
    val contentSearchState: State<ContentSearchState> = _contentSearchState


    private var currentPage = 1

    fun searchContentByQuery(query: String) {
        if (query.length >= 3) {
            searchUseCase(query, 1).onEach { res ->
                _contentSearchState.value = res
                if (res.error.peekContent() != null) currentPage = 2
            }.launchIn(viewModelScope)
        } else {
            Timber.d("search query must longer")
            currentPage = 1
            _contentSearchState.value =
                ContentSearchState(error = Event("Search query must be at least 3 characters long"))
        }
    }

    fun nextContentPageByQuery(query: String) {
        if (contentSearchState.value.data.isEmpty()) {
            return
        }

        if (query.length >= 3) {
            searchUseCase(query, currentPage).onEach { res ->

                if (res.isLoading) {
                    _contentSearchState.value = _contentSearchState.value.copy(isLoading = true)
                } else if (!res.isLoading) {
                    if (res.error.peekContent() != null) {
                        currentPage++
                        val temp = _contentSearchState.value.data.toMutableList()
                        temp.addAll(res.data)
                        _contentSearchState.value = ContentSearchState(temp)
                    } else {
                        _contentSearchState.value = _contentSearchState.value.copy(error = res.error)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}