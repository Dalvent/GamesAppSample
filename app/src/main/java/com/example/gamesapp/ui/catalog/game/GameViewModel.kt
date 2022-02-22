package com.example.gamesapp.ui.catalog.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesapp.data.models.game.GameFullModel
import com.example.gamesapp.data.repositories.GameCatalogRepository
import kotlinx.coroutines.launch

class GameViewModel(private val categoryProvider: GameCatalogRepository
) : ViewModel() {

    private val _model = MutableLiveData<GameFullModel>()
    val model: MutableLiveData<GameFullModel> = _model
    
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    fun initialize(gameId: Int) {
        viewModelScope.launch { 
            _loading.value = true
            _model.value = categoryProvider.getGameDetail(gameId)
            _loading.value = false
        }
    }
}