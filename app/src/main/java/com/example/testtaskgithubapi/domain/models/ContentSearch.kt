package com.example.testtaskgithubapi.domain.models

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

data class ContentSearch(
    /*  User  */
    val login: String,
    val id: Int,
    val avatarURL: String,
    val type: String,

)