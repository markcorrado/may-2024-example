package com.example.may2024example

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.may2024example.networking.model.SearchItem

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = viewModel()
) {
    Surface {
        Conversation(modifier, searchItems = mainViewModel.mostStarredRepos)
    }
}

@Composable
fun Conversation(modifier: Modifier = Modifier, searchItems: List<SearchItem>) {
    LazyColumn(modifier = Modifier.padding(all = 8.dp)) {
        items(searchItems) { searchItem ->
            RepositoryCard(searchItem = searchItem)
        }
    }
}

@Composable
fun RepositoryCard(modifier: Modifier = Modifier, searchItem: SearchItem) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Column {
            searchItem.name?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            searchItem.gitUrl?.let { Text(text = it) }
        }
    }
}
