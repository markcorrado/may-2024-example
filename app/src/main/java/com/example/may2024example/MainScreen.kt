package com.example.may2024example

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.may2024example.networking.model.SearchItem

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = viewModel()
) {
    Conversation(modifier, searchItems = mainViewModel.mostStarredRepos)
}

@Composable
fun Conversation(modifier: Modifier = Modifier, searchItems: List<SearchItem>) {
    LazyColumn {
        items(searchItems) { searchItem ->
            searchItem.name?.let { Text(text = it) }
        }
    }
}
