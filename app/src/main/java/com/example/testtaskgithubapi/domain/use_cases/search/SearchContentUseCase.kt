package com.example.testtaskgithubapi.domain.use_cases.search

import com.example.testtaskgithubapi.core.DispatchersProvider
import com.example.testtaskgithubapi.core.wrapper.Event
import com.example.testtaskgithubapi.core.wrapper.Resource
import com.example.testtaskgithubapi.data.local.GithubDatabase
import com.example.testtaskgithubapi.data.remote.models.dto.toUser
import com.example.testtaskgithubapi.data.repository.Repository
import com.example.testtaskgithubapi.presentation.search.state.ContentSearchState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject

class SearchContentUseCase @Inject constructor(
    private val repository: Repository,
    private val dispatchers: DispatchersProvider,
    private val githubDatabase: GithubDatabase
) {

    private val githubDao = githubDatabase.userDao()

    operator fun invoke(query: String, page: Int): Flow<ContentSearchState> {
        return flow {
            emit(ContentSearchState(isLoading = true))

            val state = when(val res = repository.searchUser(query = query, page = page)) {

                is Resource.Success -> {
                    val data = res.data?.items?.map {
                        it.toUser()
                    }.orEmpty()
                    Timber.d(res.data.toString())

//                    githubDao.deleteAllUsers()
//                    githubDao.updateUsers(data)
                    ContentSearchState(data)
                }

                is Resource.Error -> ContentSearchState(error = Event(res.message))
                is Resource.Loading -> ContentSearchState(isLoading = true)
            }

            emit(state)
        }.flowOn(dispatchers.io)
    }


}