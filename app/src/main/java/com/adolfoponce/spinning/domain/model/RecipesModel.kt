package com.adolfoponce.spinning.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class RecipesModel(
    @SerializedName("name")
    val name:String,

)


