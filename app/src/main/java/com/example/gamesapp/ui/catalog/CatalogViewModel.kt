package com.example.gamesapp.ui.catalog

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesapp.data.models.catalog.GameInCatalogModel
import com.example.gamesapp.data.repositories.GameCatalogRepository
import com.example.gamesapp.ui.catalog.game.GAME_ID_KEY
import kotlinx.coroutines.launch

class CatalogViewModel(private val categoryProvider: GameCatalogRepository
) : ViewModel() {
    private var catalogNavigator: CatalogNavigator? = null
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading
    
    private val _categories = MutableLiveData<List<GameInCatalogModel>>()
    val games: MutableLiveData<List<GameInCatalogModel>> = _categories
    
    init {
        viewModelScope.launch {
            _loading.value = true
            _categories.value = categoryProvider.getGames().sortedByDescending { it.criticsScore }
            _loading.value = false
        }
    }
    
    fun gameClick(game: GameInCatalogModel) {
        catalogNavigator!!.navigateToGameDetails(game.id)
    }

    fun initialize(catalogNavigator: CatalogNavigator) {
        this.catalogNavigator = catalogNavigator;
    }
}