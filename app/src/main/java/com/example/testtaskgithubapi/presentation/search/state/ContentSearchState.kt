package com.example.testtaskgithubapi.presentation.search.state

import com.example.testtaskgithubapi.core.wrapper.Event
import com.example.testtaskgithubapi.domain.models.ContentSearch

data class ContentSearchState(
    val data: List<ContentSearch> = listOf(),
    val isLoading: Boolean = false,
    val error: Event<String?> = Event(null)
)