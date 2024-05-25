package com.example.may2024example

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.may2024example.networking.GithubService
import com.example.may2024example.networking.RetrofitHelper
import com.example.may2024example.networking.model.SearchItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val githubApi = RetrofitHelper.getInstance().create(GithubService::class.java)

    private val _mostStarredRepos = mutableStateListOf<SearchItem>()
    val mostStarredRepos: List<SearchItem>
        get() = _mostStarredRepos

    init {
        GlobalScope.launch {
            val result = githubApi.getMostStarredGithubRepos()
            result.body()?.let {
                it.items.forEach { searchItem ->
                    _mostStarredRepos.add(searchItem)
                }
            }
        }
    }
}
