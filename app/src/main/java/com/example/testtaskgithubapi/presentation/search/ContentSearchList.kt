package com.example.testtaskgithubapi.presentation.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtaskgithubapi.presentation.search.composable.ItemSearchShimmer
import com.example.testtaskgithubapi.presentation.search.composable.ItemUserSearch
import com.example.testtaskgithubapi.presentation.search.state.ContentSearchState
import com.example.testtaskgithubapi.ui.theme.OnDarkSurface
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.unclippedBoundsInWindow

@Composable
fun ContentSearchList(
    listState: LazyListState,
    state: ContentSearchState
) {
    val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.Custom)

    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(12.dp, 0.dp, 12.dp, 0.dp),
        modifier = Modifier.onGloballyPositioned { layoutCoordinates ->
            val position = layoutCoordinates.unclippedBoundsInWindow()
            shimmerInstance.updateBounds(position)
        }
    ) {
        itemsIndexed(state.data, key = { index, data ->
            "${data.id}-$index"
        }) { _, data ->
            ItemUserSearch(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp, 8.dp),
                data = data
            )
        }

        if (state.isLoading) {
            items(10) {
                ItemSearchShimmer(shimmerInstance)
            }
        }

        val error = state.error.peekContent()
        if (error != null) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    Text(
                        text = error,
                        color = OnDarkSurface,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}