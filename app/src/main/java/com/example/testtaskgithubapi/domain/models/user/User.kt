package com.example.testtaskgithubapi.domain.models.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testtaskgithubapi.util.Constants.USER_DATABASE_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = USER_DATABASE_TABLE)
data class User(
    val login: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val avatarURL: String,
    val type: String,
)