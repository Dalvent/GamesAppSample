package com.example.gamesapp.ui.catalog

import com.example.gamesapp.R
import com.example.gamesapp._base.SimpleSingleAdapter
import com.example.gamesapp.databinding.TagItemBinding

class TagsAdapter() : SimpleSingleAdapter<String, TagItemBinding>(R.layout.tag_item, null) {
    override fun createViewHolder(binding: TagItemBinding): BindableViewHolder<String, TagItemBinding> {
        return TagViewHolder(binding)
    }

    class TagViewHolder(binding: TagItemBinding) : BindableViewHolder<String, TagItemBinding>(binding) {
        override fun setup(item: String) {
            binding.tag = item
        }
    }
}