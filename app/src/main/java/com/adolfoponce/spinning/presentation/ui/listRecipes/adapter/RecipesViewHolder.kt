package com.adolfoponce.spinning.presentation.ui.listRecipes.adapter

import android.content.Context
import android.util.Log
import com.adolfoponce.spinning.R
import com.adolfoponce.spinning.databinding.ItemRecyclerCategorieStoreBinding
import com.adolfoponce.spinning.domain.model.CategoriesModel
import com.adolfoponce.spinning.domain.model.IngredientsModel
import com.adolfoponce.spinning.domain.model.RecipesModel
import com.adolfoponce.spinning.presentation.ui.listRecipes.listeners.onSelectRecipe
import com.bumptech.glide.Glide


class RecipesViewHolder(val binding: ItemRecyclerCategorieStoreBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root){

    fun onBindItem(
        item: CategoriesModel,
        context: Context,
        listener: onSelectRecipe
    ) {
        Log.e("XXXXXX","eeeee" + item.name +"/"+item.url)
             binding.nameCategorie.text = item.name
        Glide.with(context).asBitmap().load(item.url).into(binding.imageCategorie)
        binding.imageCategorie.setOnClickListener {
            listener.onClickRecipe(null)
        }
    }
}