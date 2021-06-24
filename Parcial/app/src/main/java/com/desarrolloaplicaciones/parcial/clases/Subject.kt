package com.desarrolloaplicaciones.parcial.clases

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
class Subject(id: Int,userId:Int, name: String, link: String, schedule: String):Parcelable {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int

    @ColumnInfo(name = "userId")
    var userId : Int

    @ColumnInfo(name = "name")
    var name : String

    @ColumnInfo(name = "link")
    var link: String
    
    @ColumnInfo(name = "schedule")
    var schedule: String

    constructor(parcel: Parcel) : this(
        TODO("id"),
        TODO("userId"),
        TODO("name"),
        TODO("link"),
        TODO("schedule")
    ) {
        id = parcel.readInt()
        userId = parcel.readInt()
        name = parcel.readString().toString()
        link = parcel.readString().toString()
        schedule = parcel.readString().toString()
    }

    init {
        this.id = id
        this.userId = userId
        this.name = name
        this.link = link
        this.schedule = schedule
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(userId)
        parcel.writeString(name)
        parcel.writeString(link)
        parcel.writeString(schedule)
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