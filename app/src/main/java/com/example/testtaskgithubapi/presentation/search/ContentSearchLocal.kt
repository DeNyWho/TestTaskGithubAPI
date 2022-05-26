package com.example.testtaskgithubapi.presentation.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testtaskgithubapi.domain.models.ContentSearch
import com.example.testtaskgithubapi.presentation.search.composable.ItemUserSearch

@Composable
fun ContentSearchLocal(
    listState: LazyListState,
    searchQuery: String,
    users: List<ContentSearch>
) {

    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(12.dp, 0.dp, 12.dp, 0.dp),
    ) {
        item {
            Text(
                text = "Last request",
                modifier = Modifier.padding(bottom = 20.dp)
            )
        }

        itemsIndexed(users, key = { index, data ->
            "${data.id}-$index"
        }) { _, data ->
            if (data.login.contains(searchQuery))
                ItemUserSearch(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp, 8.dp),
                    data = data
                )
        }

    }


}