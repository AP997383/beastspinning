package com.adolfoponce.spinning.utils.ui.carrousel.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.adolfoponce.spinning.utils.ui.carrousel.ImageCarousel
import com.adolfoponce.spinning.utils.ui.carrousel.model.CarouselGravity
import com.adolfoponce.spinning.utils.ui.carrousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.model.CarouselType

class InfiniteCarouselAdapter(
    recyclerView: RecyclerView,
    carouselType: CarouselType,
    carouselGravity: CarouselGravity,
    autoWidthFixing: Boolean,
    imageScaleType: ImageView.ScaleType,
    imagePlaceholder: Drawable?
) : FiniteCarouselAdapter(
    recyclerView,
    carouselType,
    carouselGravity,
    autoWidthFixing,
    imageScaleType,
    imagePlaceholder
) {
    override fun getItemCount(): Int {
        return if (dataList.isEmpty()) 0 else Integer.MAX_VALUE
    }

    override fun getItem(position: Int): Any? {
        return if (position < itemCount) {
            dataList[position % dataList.size]
        } else {
            null
        }
    }

    override fun getRealDataPosition(position: Int): Int {
        if (dataList.size == 0) return ImageCarousel.NO_POSITION
        return position % dataList.size
    }
}
