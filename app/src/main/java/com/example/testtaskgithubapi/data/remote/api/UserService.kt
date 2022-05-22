package com.example.testtaskgithubapi.data.remote.api

import androidx.room.Query
import com.example.testtaskgithubapi.core.wrapper.Resource
import com.example.testtaskgithubapi.data.remote.models.dto.ContentSearchResponse
import com.example.testtaskgithubapi.presentation.search.state.ContentSearchState

interface UserService {

    suspend fun searchUser(query: String, page: Int): Resource<ContentSearchResponse>
}