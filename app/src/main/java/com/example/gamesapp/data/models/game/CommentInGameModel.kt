package com.example.gamesapp.data.models.game

data class CommentInGameModel(
    val id: Int,
    val text: String,
    val author: CommentAuthorInGameModel,
    val rootComment: CommentInGameModel?
)