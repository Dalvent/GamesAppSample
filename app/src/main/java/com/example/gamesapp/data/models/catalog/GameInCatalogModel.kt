package com.example.gamesapp.data.models.catalog

data class GameInCatalogModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val criticsScore: Float,
    val tags: List<String>
)

