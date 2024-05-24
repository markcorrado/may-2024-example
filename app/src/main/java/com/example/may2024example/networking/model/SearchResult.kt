package com.example.may2024example.networking.model

import com.google.gson.annotations.SerializedName

data class SearchResult (
    @SerializedName("total_count")
    val totalCount: Int? = null,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean? = null,
    @SerializedName("items")
    val items: ArrayList<SearchItem> = arrayListOf()
)