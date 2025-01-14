package com.adolfoponce.spinning.presentation.ui.feed.adapter

import android.content.Context
import android.util.Log
import com.adolfoponce.spinning.databinding.ItemFeedBinding
import com.adolfoponce.spinning.databinding.ItemFeedMultimediaBinding
import com.adolfoponce.spinning.databinding.ItemRecyclerCategorieStoreBinding
import com.adolfoponce.spinning.domain.model.CategoriesModel
import com.adolfoponce.spinning.presentation.ui.listRecipes.listeners.onSelectRecipe
import com.bumptech.glide.Glide


class MultimediaViewHolder(val binding: ItemFeedMultimediaBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root){

    fun onBindItem(
        item: CategoriesModel,
        context: Context,
        listener: onSelectRecipe
    ) {
             Glide.with(context)
                 .load("https://images.hola.com/imagenes/estar-bien/20230227226978/spinning-consejos-utiles-primera-clase/1-208-337/spinning-t.jpg")
                 .into(binding.image)
    }
}