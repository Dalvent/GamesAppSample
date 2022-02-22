package com.example.gamesapp.data.models.game

data class GameFullModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val criticsScore: Float,
    val tags: List<String>,
    val description: String,
    val developer: DeveloperOfGameModel,
    val publisher: PublisherOfGameModel
)

