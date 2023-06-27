package com.adolfoponce.spinning.presentation.ui.feed.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.adolfoponce.spinning.databinding.ItemFeedBinding
import com.adolfoponce.spinning.domain.model.CategoriesModel
import com.adolfoponce.spinning.presentation.ui.feed.adapter.FeedViewHolder
import com.adolfoponce.spinning.presentation.ui.listRecipes.listeners.onSelectRecipe

class FeedAdapter (context: Context, items:ArrayList<CategoriesModel>, listener: onSelectRecipe) : androidx.recyclerview.widget.RecyclerView.Adapter<FeedViewHolder>() {

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


    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): FeedViewHolder {
        val view =ItemFeedBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        Log.e("XXXXXX","onCreateViewHolder"+items.size)
        return FeedViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.e("XXXXXX","couddddntessssssssr"+items.size)
        return 10
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        Log.e("XXXXXX","onBindViewHolderxxxxxxxx" + position)
      //  holder.binding.root.animation = AnimationUtils.loadAnimation(holder.itemView.context,R.anim.anim_item_recycler)
     //   holder.onBindItem(items.get(position), context,this.listener)
    }


}