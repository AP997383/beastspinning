package com.adolfoponce.spinning.presentation.ui.select_place.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.adolfoponce.spinning.R
import com.adolfoponce.spinning.databinding.ItemPreviewReservesDaysListBinding
import com.adolfoponce.spinning.domain.model.CategoriesModel
import com.adolfoponce.spinning.presentation.ui.listRecipes.listeners.onSelectRecipe

class ListaClasesPorDiaAdapter (context: Context, items:ArrayList<CategoriesModel>, listener: onSelectRecipe) : androidx.recyclerview.widget.RecyclerView.Adapter<ListaClasesPorDiaViewHolder>() {

    private  var context: Context
    private var listener: onSelectRecipe
    private var items = arrayListOf<CategoriesModel>()

    init {
        this.context =context
        this.items = items
        this.listener =listener
    }

    fun updateList(items:ArrayList<CategoriesModel>){
        Log.e("XXXXXX","updateList"+items.size)
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
        Log.e("XXXXXX","updateListxxx"+items.size)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ListaClasesPorDiaViewHolder {
        val view =ItemPreviewReservesDaysListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        Log.e("XXXXXX","onCreateViewHolder"+items.size)
        return ListaClasesPorDiaViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.e("XXXXXX","couddddntessssssssr"+items.size)
        return items.size
    }

    override fun onBindViewHolder(holder: ListaClasesPorDiaViewHolder, position: Int) {
        Log.e("XXXXXX","onBindViewHolderxxxxxxxx" + position)
       // holder.binding.root.animation = AnimationUtils.loadAnimation(holder.itemView.context,R.anim.anim_item_recycler)
        holder.onBindItem(items.get(position), context,this.listener)
    }


}