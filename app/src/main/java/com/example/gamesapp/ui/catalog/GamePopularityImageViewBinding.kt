package com.example.gamesapp.ui.catalog

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesapp.R
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager

@BindingAdapter("gameRateAsImage")
fun gamePopularityIconImageViewBinding(imageView: ImageView, gameRate: Float) {
    val drawableId = when {
        gameRate > 8.8 -> R.drawable.ic_double_arrow_up_24
        gameRate > 5.0 -> R.drawable.ic_arrow_up_24
        gameRate > 2.8 -> R.drawable.ic_arrow_down_24
        else -> R.drawable.ic_double_arrow_down_24
    }

    val color = colorResourceByGameRate(gameRate)

    imageView.setImageResource(drawableId)
    imageView.setColorFilter(imageView.context.getColor(color))
}

@BindingAdapter("gameRateAsColor")
fun gamePopularityIconImageViewBinding(textView: TextView, gameRate: Float) {
    textView.setTextColor(textView.context.getColor(colorResourceByGameRate(gameRate)))
}

@BindingAdapter("tags")
fun tagsListRecyclerViewBinding(recyclerView: RecyclerView, tags: List<String>?) {
    if(tags == null) {
        recyclerView.adapter = null
        return
    }
    
    if(recyclerView.adapter == null || recyclerView.adapter !is TagsAdapter) {
        recyclerView.adapter = TagsAdapter()
        recyclerView.layoutManager = FlexboxLayoutManager(recyclerView.context, FlexDirection.ROW)
    }
    (recyclerView.adapter as TagsAdapter).updateItems(tags)
}

private fun colorResourceByGameRate(gameRate: Float): Int {
    val color = if (gameRate > 5.0) R.color.rate_good else R.color.rate_bad;
    return color
}