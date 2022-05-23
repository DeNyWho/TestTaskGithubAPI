package com.example.testtaskgithubapi.presentation.search

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testtaskgithubapi.core.DispatchersProvider
import com.example.testtaskgithubapi.core.enum.ContentType
import com.example.testtaskgithubapi.presentation.search.composable.CustomTextField
import com.example.testtaskgithubapi.presentation.search.composable.SearchEditText
import com.example.testtaskgithubapi.presentation.search.composable.SearchLeadingIcon
import com.example.testtaskgithubapi.presentation.search.composable.SearchTrailingIcon
import com.example.testtaskgithubapi.ui.theme.BlackBackground
import com.example.testtaskgithubapi.ui.theme.Grey
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

@Composable
fun Search(
    viewModel: SearchViewModel,
    dispatchers: DispatchersProvider
){

    val listState = rememberLazyListState()
    val searchQuery = rememberSaveable { mutableStateOf("")}
    val focusRequester = remember { (FocusRequester()) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = viewModel.hashCode()) {
        focusRequester.requestFocus()
    }
    val contentSearchState = viewModel.contentSearchState.value

    val job = remember { mutableStateOf<Job?>(null)}


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground),
        scaffoldState = rememberScaffoldState()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.fillMaxWidth()) {
                CustomTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp, 12.dp),
                    padding = PaddingValues(12.dp),
                    content = {
                        SearchEditText(
                            value = searchQuery.value,
                            placeholder = "Try 'Denywho'",
                            focusRequester = focusRequester,
                            onValueChange = {
                                searchQuery.value = it
                                job.value?.cancel()
                                job.value = scope.launch (dispatchers.default) {
                                    delay(1000L)
                                    viewModel.searchContentByQuery(searchQuery.value)
                                }
                            }
                        )
                    },
                    leadingIcon = {
                        SearchLeadingIcon(
                            size = 16.dp,
                            padding = PaddingValues(end = 8.dp)
                        )
                    },
                    trailingIcon = {
                        if (searchQuery.value.isNotEmpty()) {
                            SearchTrailingIcon(
                                size = 16.dp,
                                padding = PaddingValues(start = 8.dp),
                                onClick = { searchQuery.value = "" })
                        }
                    }
                )
            }
            BackHandler(enabled = (searchQuery.value.isNotEmpty())) {
                searchQuery.value = ""
            }

            ContentSearchList(
                listState = listState,
                state = contentSearchState
            )

            Timber.d("TIMBER = TIMBEr")

            if (listState.isScrolledToTheEnd()) {
                LaunchedEffect(searchQuery.value) {
                    Timber.i("query next page with $searchQuery.value")
                    viewModel.nextContentPageByQuery(searchQuery.value)
                }
            }
        }


    }

}

fun LazyListState.isScrolledToTheEnd(): Boolean {
    return layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
}

























