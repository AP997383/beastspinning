package com.adolfoponce.spinning.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class DirectionsModel(
    @SerializedName("description")
    val description:String
):Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DirectionsModel> {
        override fun createFromParcel(parcel: Parcel): DirectionsModel {
            return DirectionsModel(parcel)
        }

        override fun newArray(size: Int): Array<DirectionsModel?> {
            return arrayOfNulls(size)
        }
    }
}
