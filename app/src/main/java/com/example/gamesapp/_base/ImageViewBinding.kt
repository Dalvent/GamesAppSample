package com.example.gamesapp._base

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.gamesapp.R
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if(imageUrl == null)
        return
    
    Picasso.get()
        .load(imageUrl)
        .into(view)
}

@BindingAdapter("imageUrl", "placeholder")
fun loadImage(view: ImageView, imageUrl: String?, placeholder: Drawable?) {
    if(imageUrl == null || placeholder == null)
        return
    
    Picasso.get()
        .load(imageUrl)
        .placeholder(placeholder)
        .into(view)
}

@BindingAdapter("imageUrl", "placeholder", "error")
fun loadImage(view: ImageView, imageUrl: String?, placeholder: Drawable?, error: Drawable?) {
    if(imageUrl == null || placeholder == null || error == null)
        return
    
    Picasso.get()
        .load(imageUrl)
        .placeholder(placeholder)
        .error(error)
        .into(view)
}

@BindingAdapter("imageUrl", "error")
fun loadImageWithError(view: ImageView, imageUrl: String?, error: Drawable?) {
    if(imageUrl == null || error == null)
        return
    
    Picasso.get()
        .load(imageUrl)
        .error(error)
        .into(view)
}

