package com.example.asus.submission2

import android.os.Parcel
import android.os.Parcelable

data class TvShowClass (
    val title : String ?,
    val img : Int ?,
    val desc : String ?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeValue(img)
        parcel.writeString(desc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TvShowClass> {
        override fun createFromParcel(parcel: Parcel): TvShowClass {
            return TvShowClass(parcel)
        }

        override fun newArray(size: Int): Array<TvShowClass?> {
            return arrayOfNulls(size)
        }
    }

}