package com.adolfoponce.spinning.presentation.ui.select_place.adapter

import android.content.Context
import android.util.Log
import com.adolfoponce.spinning.databinding.ItemPreviewReservesDaysListBinding
import com.adolfoponce.spinning.databinding.ItemRecyclerCategorieStoreBinding
import com.adolfoponce.spinning.domain.model.CategoriesModel
import com.adolfoponce.spinning.presentation.ui.listRecipes.listeners.onSelectRecipe
import com.bumptech.glide.Glide


class ListaClasesPorDiaViewHolder(val binding: ItemPreviewReservesDaysListBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root){

    fun onBindItem(
        item: CategoriesModel,
        context: Context,
        listener: onSelectRecipe
    ) {
        binding.root.setOnClickListener {
            listener.onClickRecipe(null)
        }
        Log.e("XXXXXX","eeeee" + item.name +"/"+item.url)

    }
}