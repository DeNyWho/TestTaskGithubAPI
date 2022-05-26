package com.example.testtaskgithubapi.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testtaskgithubapi.domain.models.ContentSearch
import com.example.testtaskgithubapi.domain.models.user.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): Flow<List<ContentSearch>>

    @Query("SELECT * FROM user_table WHERE id=:userId")
    fun getSelectUser(userId: Int): User

    @Insert
    suspend fun updateUsers(users: List<ContentSearch>)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()
}