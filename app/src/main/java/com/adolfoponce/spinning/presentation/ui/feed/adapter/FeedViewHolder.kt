package com.adolfoponce.spinning.presentation.ui.feed.adapter

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.adolfoponce.spinning.databinding.ItemFeedBinding
import com.adolfoponce.spinning.databinding.ItemRecyclerCategorieStoreBinding
import com.adolfoponce.spinning.domain.model.CategoriesModel
import com.adolfoponce.spinning.presentation.ui.listRecipes.listeners.onSelectRecipe
import com.bumptech.glide.Glide


class FeedViewHolder(val binding: ItemFeedBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root){

    fun onBindItem(
        item: CategoriesModel,
        context: Context,
        listener: onSelectRecipe
    ) {
        var adapter = MultimediaAdapter(context, arrayListOf()){ }
         binding.listaMultimediaFeed.adapter = adapter
         binding.listaMultimediaFeed.layoutManager =LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    }
}