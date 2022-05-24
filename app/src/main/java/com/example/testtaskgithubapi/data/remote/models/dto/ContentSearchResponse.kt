package com.example.testtaskgithubapi.data.remote.models.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentSearchResponse(

    @SerialName("total_count")
    val totalCount: Int,

    @SerialName("incomplete_results")
    val incompleteResults: Boolean,

    @SerialName("items")
    val `items`: List<UserDto> = listOf()
)