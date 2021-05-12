package com.desarrolloaplicaciones.parcial.clases

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
class User(id: Int,var user: String, var pw: String) {

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int

    @ColumnInfo(name = "username")
    var userName: String

    @ColumnInfo(name = "password")
    var passWord: String


    init {
        this.id = id
        this.userName = user
        this.passWord = pw

    }

    /*fun verifyUser (aUser: String, aPass: String): Boolean {

        return (aUser == this.userName) and (aPass == this.passWord)


    }*/
}