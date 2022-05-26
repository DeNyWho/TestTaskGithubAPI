package com.example.testtaskgithubapi.presentation.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.testtaskgithubapi.core.wrapper.Event
import com.example.testtaskgithubapi.data.repository.Remote
import com.example.testtaskgithubapi.domain.models.ContentSearch
import com.example.testtaskgithubapi.domain.use_cases.search.SearchContentUseCase
import com.example.testtaskgithubapi.presentation.search.state.ContentSearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchContentUseCase,
    private val remote: Remote
): ViewModel() {

    private val _contentSearchState: MutableState<ContentSearchState> =
        mutableStateOf(ContentSearchState())
    val contentSearchState: State<ContentSearchState> = _contentSearchState

//    fun setUsers(users: List<ContentSearch>){
//        viewModelScope.launch {
//            remote.updateUsers(users)
//        }
//    }

    val userList: LiveData<List<ContentSearch>> = remote.getAllUsers().asLiveData()


    private var currentPage = 1

    fun searchContentByQuery(query: String) {
        if (query.length >= 3) {
            searchUseCase(query, 1).onEach { res ->
                _contentSearchState.value = res
                if (res.error.peekContent() != null) currentPage = 2
            }.launchIn(viewModelScope)
        } else {
            Timber.d("search query must longer")
            _contentSearchState.value =
                ContentSearchState(error = Event("Search query must be at least 3 characters long"))
        }
    }


    fun getNextPage(query: String){
        if (query.length >= 3) {
            currentPage++
            searchUseCase(query, currentPage).onEach { res ->
                val temp = _contentSearchState.value.data.toMutableList()
                temp.addAll(res.data)
                _contentSearchState.value.data = temp
                if (res.error.peekContent() != null) currentPage = 2
            }.launchIn(viewModelScope)
        }
    }
}