package com.example.testtaskgithubapi.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testtaskgithubapi.util.Constants

@Entity(tableName = Constants.CONTENT_SEARCH_TABLE)
data class ContentSearch(
    /*  User  */
    val login: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val avatarURL: String,
    val type: String,

)