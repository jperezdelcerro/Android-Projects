package com.desarrolloaplicaciones.desafio3.Clases

import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable

class Food(var name: String?, var aPrice: Int): Parcelable{

    var foodName: String? = name
    var price: Int = aPrice
    lateinit var image: Drawable

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    ) {
        foodName = parcel.readString().toString()
        price = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(aPrice)
        parcel.writeString(foodName)
        parcel.writeInt(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Food> {
        override fun createFromParcel(parcel: Parcel): Food {
            return Food(parcel)
        }

        override fun newArray(size: Int): Array<Food?> {
            return arrayOfNulls(size)
        }
    }


}
