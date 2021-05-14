package com.desarrolloaplicaciones.parcial.clases

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
class Subject(id: Int,userId:Int, name: String, link: String) {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int

    @ColumnInfo(name = "userId")
    var userId : Int

    @ColumnInfo(name = "name")
    var name : String

    @ColumnInfo(name = "link")
    var link: String


    init {
        this.id = id
        this.userId = userId
        this.name = name
        this.link = link

    }

}