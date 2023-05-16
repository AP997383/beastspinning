package com.adolfoponce.spinning.domain.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MetricsModel(
    @SerializedName("minutes")
    val minutes:Int,
    @SerializedName("portions")
    val portions:Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(minutes)
        parcel.writeInt(portions)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MetricsModel> {
        override fun createFromParcel(parcel: Parcel): MetricsModel {
            return MetricsModel(parcel)
        }

        override fun newArray(size: Int): Array<MetricsModel?> {
            return arrayOfNulls(size)
        }
    }
}
