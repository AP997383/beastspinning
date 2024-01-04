package com.adolfoponce.spinning.presentation.ui.explore.adapter

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.adolfoponce.spinning.databinding.ItemFeedBinding
import com.adolfoponce.spinning.databinding.ItemRecyclerCategorieStoreBinding
import com.adolfoponce.spinning.databinding.ItemStudioBinding
import com.adolfoponce.spinning.domain.model.CategoriesModel
import com.adolfoponce.spinning.presentation.ui.listRecipes.listeners.onSelectRecipe
import com.bumptech.glide.Glide


class ExploreViewHolder(val binding:ItemStudioBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root){

    fun onBindItem(
        item: CategoriesModel,
        context: Context,
        listener: onSelectRecipe
    ) {
        Glide.with(context)
            .load("https://images-platform.99static.com/_NYgKTTwatsBjpcuOrdeeog_18o=/500x500/top/smart/99designs-contests-attachments/32/32584/attachment_32584143")
            .into(binding.logoStudio)
        binding.verSucursales.setOnClickListener {
            if(binding.expandable.isExpanded){
                binding.expandable.collapse()
            }else
            {
                binding.expandable.expand()
            }
        }

         /*var adapter = MultimediaAdapter(context, arrayListOf()){ }
         binding.listaMultimediaFeed.adapter = adapter
         binding.listaMultimediaFeed.layoutManager =LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)*/
    }
}