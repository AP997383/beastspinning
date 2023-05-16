package com.adolfoponce.spinning.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class IngredientsModel(
    @SerializedName("name")
    val name:String,
    @SerializedName("quantity")
    val quantity:String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(quantity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IngredientsModel> {
        override fun createFromParcel(parcel: Parcel): IngredientsModel {
            return IngredientsModel(parcel)
        }

        override fun newArray(size: Int): Array<IngredientsModel?> {
            return arrayOfNulls(size)
        }
    }
}
