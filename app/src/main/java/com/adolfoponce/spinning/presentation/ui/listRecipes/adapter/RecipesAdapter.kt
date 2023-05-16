package com.adolfoponce.spinning.presentation.ui.listRecipes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.adolfoponce.spinning.databinding.ItemHistoryClassBinding
import com.adolfoponce.spinning.databinding.RecipesItemBinding
import com.adolfoponce.spinning.domain.model.RecipesModel
import com.adolfoponce.spinning.presentation.ui.listRecipes.listeners.onSelectRecipe

class RecipesAdapter (context: Context, items:ArrayList<RecipesModel>, listener: onSelectRecipe) : androidx.recyclerview.widget.RecyclerView.Adapter<RecipesViewHolder>() {

    private  var context: Context
    private var listener: onSelectRecipe
    private var items = arrayListOf<RecipesModel>()

    init {
        this.context =context
        this.items = items
        this.listener =listener
    }

    fun updateList(items:ArrayList<RecipesModel>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): RecipesViewHolder {
        val view =ItemHistoryClassBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return RecipesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.onBindItem(RecipesModel(""), context,this.listener)
    }


}