package com.example.gamesapp

import android.app.Application
import com.example.gamesapp.data.repositories.GameCatalogRepository
import com.example.gamesapp.data.repositories.MockGameCatalogRepository
import com.example.gamesapp.ui.catalog.CatalogViewModel
import com.example.gamesapp.ui.catalog.game.GameViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module


class App : Application() {
    val module = module { 
        single<GameCatalogRepository> { MockGameCatalogRepository() }
        factory { CatalogViewModel(get()) }
        factory { GameViewModel(get()) }
    }
    
    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(module)
        }
    }
}