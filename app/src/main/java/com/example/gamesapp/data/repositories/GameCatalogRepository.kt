package com.example.gamesapp.data.repositories

import com.example.gamesapp.data.models.catalog.GameInCatalogModel
import com.example.gamesapp.data.models.game.GameFullModel

interface GameCatalogRepository {
    suspend fun getGames(): List<GameInCatalogModel>
    suspend fun getGameDetail(id: Int): GameFullModel
}