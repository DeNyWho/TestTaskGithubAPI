package com.example.testtaskgithubapi.data.repository

import com.example.testtaskgithubapi.data.local.dao.UserDao
import com.example.testtaskgithubapi.domain.models.ContentSearch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Remote @Inject constructor(
    private val dao: UserDao
) {
    fun getAllUsers(): Flow<List<ContentSearch>> = dao.getAllUsers()
        .flowOn(Dispatchers.Main)
        .conflate()

    suspend fun updateUsers(users: List<ContentSearch>){
        dao.updateUsers(users)
    }
}