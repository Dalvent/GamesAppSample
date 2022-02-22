package com.example.gamesapp.data.repositories

import com.example.gamesapp.data.models.catalog.GameInCatalogModel
import com.example.gamesapp.data.models.game.GameFullModel

class GameCatalogRepositoryImpl : GameCatalogRepository {
    override suspend fun getGames(): List<GameInCatalogModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getGameDetail(id: Int): GameFullModel {
        TODO("Not yet implemented")
    }
}