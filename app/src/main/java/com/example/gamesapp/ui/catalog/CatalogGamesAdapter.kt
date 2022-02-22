package com.example.gamesapp.ui.catalog

import com.example.gamesapp.R
import com.example.gamesapp._base.SimpleSingleAdapter
import com.example.gamesapp.data.models.catalog.GameInCatalogModel
import com.example.gamesapp.databinding.CatalogGameItemBinding
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager

class CatalogGamesAdapter(itemClick: ((GameInCatalogModel) -> Unit)?) :
    SimpleSingleAdapter<GameInCatalogModel, CatalogGameItemBinding>(R.layout.catalog_game_item, itemClick) {

    override fun createViewHolder(binding: CatalogGameItemBinding): BindableViewHolder<GameInCatalogModel, CatalogGameItemBinding> {
        return GameViewHolder(binding)
    }

    class GameViewHolder(binding: CatalogGameItemBinding) : BindableViewHolder<GameInCatalogModel, CatalogGameItemBinding>(binding) {
        override fun setup(item: GameInCatalogModel) {
            binding.model = item
            
            val tagsAdapter = TagsAdapter()
            tagsAdapter.updateItems(item.tags)
            binding.tagsRecyclerView.adapter = tagsAdapter
            val layoutManager = FlexboxLayoutManager(itemView.context)
            layoutManager.flexDirection = FlexDirection.ROW
            binding.tagsRecyclerView.layoutManager = layoutManager
        }
    }
}
        