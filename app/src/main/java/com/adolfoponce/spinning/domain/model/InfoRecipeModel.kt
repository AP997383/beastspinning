package com.adolfoponce.spinning.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class InfoRecipeModel(
    @SerializedName("sugar")
    val sugar:Int,
    @SerializedName("salt")
    val salt:Int,
    @SerializedName("calories")
    val calories:Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(sugar)
        parcel.writeInt(salt)
        parcel.writeInt(calories)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InfoRecipeModel> {
        override fun createFromParcel(parcel: Parcel): InfoRecipeModel {
            return InfoRecipeModel(parcel)
        }

        override fun newArray(size: Int): Array<InfoRecipeModel?> {
            return arrayOfNulls(size)
        }
    }
}
