package com.adolfoponce.spinning.presentation.ui.explore.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.adolfoponce.spinning.databinding.ItemFeedBinding
import com.adolfoponce.spinning.databinding.ItemRecyclerCategorieStoreBinding
import com.adolfoponce.spinning.databinding.ItemStudioBinding
import com.adolfoponce.spinning.domain.model.CategoriesModel
import com.adolfoponce.spinning.domain.model.StudioModel
import com.adolfoponce.spinning.presentation.ui.listRecipes.listeners.onSelectRecipe
import com.bumptech.glide.Glide


class ExploreViewHolder(val binding:ItemStudioBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root){

    fun onBindItem(
        item: StudioModel,
        context: Context,
        listener: onSelectRecipe
    ) {
        Glide.with(context)
            .load(item.logo_studio)
            .into(binding.logoStudio)
        binding.verSucursales.setOnClickListener {
            if(binding.expandable.isExpanded){
                binding.expandable.collapse()
            }else
            {
                binding.expandable.expand()
            }
        }
        with(binding){
            nombreStudio.setText(item.nombre_estudio)
            domicilioStudio.setText(item.address)
            for (day:String in item.days_works){
                when(day){
                    "LU"->{  dayLu.setCardBackgroundColor(Color.parseColor("#4CAF50"))}
                    "MA"->{  dayMa.setCardBackgroundColor(Color.parseColor("#4CAF50"))}
                    "MI"->{  dayMi.setCardBackgroundColor(Color.parseColor("#4CAF50"))}
                    "JU"->{  dayJu.setCardBackgroundColor(Color.parseColor("#4CAF50"))}
                    "VI"->{  dayVi.setCardBackgroundColor(Color.parseColor("#4CAF50"))}
                    "SA"->{  daySa.setCardBackgroundColor(Color.parseColor("#4CAF50"))}
                    "DO"->{  dayDo.setCardBackgroundColor(Color.parseColor("#4CAF50"))}
                }


            }
        }

         /*var adapter = MultimediaAdapter(context, arrayListOf()){ }
         binding.listaMultimediaFeed.adapter = adapter
         binding.listaMultimediaFeed.layoutManager =LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)*/
    }
}