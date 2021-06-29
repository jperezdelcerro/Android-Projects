package com.desarrolloaplicaciones.parcial.clases

import android.text.Editable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
class User(id: Int, username: String, password: String) {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int

    @ColumnInfo(name = "username")
    var username: String

    @ColumnInfo(name = "password")
    var password: String


    init {
        this.id = id
        this.username = username
        this.password = password

    }

    fun verifyUser(aUser: String, aPass: String): Boolean {

        return (aUser == this.username) and (aPass == this.password)


    }

}
