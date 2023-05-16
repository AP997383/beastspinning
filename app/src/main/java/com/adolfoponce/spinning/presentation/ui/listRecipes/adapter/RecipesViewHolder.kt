package com.adolfoponce.spinning.presentation.ui.listRecipes.adapter

import android.content.Context
import com.adolfoponce.spinning.R
import com.adolfoponce.spinning.domain.model.IngredientsModel
import com.adolfoponce.spinning.domain.model.RecipesModel
import com.adolfoponce.spinning.presentation.ui.listRecipes.listeners.onSelectRecipe
import com.bumptech.glide.Glide


class RecipesViewHolder(val binding: com.adolfoponce.spinning.databinding.ItemHistoryClassBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root){

    fun onBindItem(
        item: RecipesModel,
        context: Context,
        listener: onSelectRecipe
    ) {

    }
}