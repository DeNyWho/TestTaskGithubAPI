package com.example.testtaskgithubapi.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.example.testtaskgithubapi.domain.models.user.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getAllUsers(): PagingSource<Int, User>

    @Query("SELECT * FROM user_table WHERE id=:userId")
    fun getSelectUser(userId: Int): User

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()
}