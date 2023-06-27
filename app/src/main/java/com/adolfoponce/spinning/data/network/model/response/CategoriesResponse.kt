package com.adolfoponce.spinning.data.network.model.response

import com.adolfoponce.spinning.domain.model.CategoriesModel

data class CategoriesResponse(
   var items:ArrayList<CategoriesModel>
) {
   constructor() : this(arrayListOf())
}
