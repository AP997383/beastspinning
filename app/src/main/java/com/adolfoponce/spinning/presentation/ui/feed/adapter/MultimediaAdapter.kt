package com.adolfoponce.spinning.presentation.ui.feed.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.adolfoponce.spinning.databinding.ItemFeedBinding
import com.adolfoponce.spinning.databinding.ItemFeedMultimediaBinding
import com.adolfoponce.spinning.domain.model.CategoriesModel
import com.adolfoponce.spinning.presentation.ui.feed.adapter.FeedViewHolder
import com.adolfoponce.spinning.presentation.ui.listRecipes.listeners.onSelectRecipe

class MultimediaAdapter (context: Context, items:ArrayList<CategoriesModel>, listener: onSelectRecipe) : androidx.recyclerview.widget.RecyclerView.Adapter<MultimediaViewHolder>() {

    private  var context: Context
    private var listener: onSelectRecipe
    private var items = arrayListOf<CategoriesModel>()

    init {
        this.context =context
        this.items = items
        this.listener =listener
    }

    fun updateList(items:ArrayList<CategoriesModel>){

        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MultimediaViewHolder {
        val view =ItemFeedMultimediaBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        Log.e("XXXXeeXX","onCreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeateViewHolder"+items.size)
        return MultimediaViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.e("XXXXXX","couddddntessssssssr"+items.size)
        return 10
    }

    override fun onBindViewHolder(holder: MultimediaViewHolder, position: Int) {
        Log.e("XXXXXX","onBindViewHolderxxxxxxxx" + position)
      //  holder.binding.root.animation = AnimationUtils.loadAnimation(holder.itemView.context,R.anim.anim_item_recycler)
        holder.onBindItem(CategoriesModel("",""), context,this.listener)
    }


}