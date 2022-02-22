package com.example.gamesapp._base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class SimpleSingleAdapter<TItem, TBinding : ViewDataBinding>(
    val itemResourceId: Int,
    val itemClick: ((TItem) -> Unit)?
) : RecyclerView.Adapter<SimpleSingleAdapter.BindableViewHolder<TItem, TBinding>>() {
    private var items: List<TItem> = listOf()

    abstract fun createViewHolder(binding: TBinding): BindableViewHolder<TItem, TBinding>

    fun updateItems(items: List<TItem>) {
        this.items = items
        this.notifyItemRangeChanged(0, items.size)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindableViewHolder<TItem, TBinding> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<TBinding>(inflater, viewType, parent, false)
        return createViewHolder(binding);
    }

    override fun onBindViewHolder(holder: BindableViewHolder<TItem, TBinding>, position: Int) {
        val currentItem = items[position]
        holder.setup(currentItem)

        if (itemClick != null) {
            holder.itemView.setOnClickListener {
                itemClick.invoke(currentItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return itemResourceId
    }


    abstract class BindableViewHolder<TItem, TBinding : ViewDataBinding>(val binding: TBinding) :
        RecyclerView.ViewHolder(binding.root) {
        abstract fun setup(item: TItem)
    }
}