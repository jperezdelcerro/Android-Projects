package com.desarrolloaplicaciones.parcial.clases

import android.os.Parcel
import android.os.Parcelable

class Subject(var name: String?, var image: String?):Parcelable{


    var subjectName: String? = name
    var subjectIcon: String? = image

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
        subjectName = parcel.readString().toString()
        subjectIcon = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(subjectName)
        parcel.writeString(subjectIcon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Subject> {
        override fun createFromParcel(parcel: Parcel): Subject {
            return Subject(parcel)
        }

        override fun newArray(size: Int): Array<Subject?> {
            return arrayOfNulls(size)
        }
    }

}