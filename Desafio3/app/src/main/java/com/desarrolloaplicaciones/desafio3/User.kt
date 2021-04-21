package com.desarrolloaplicaciones.desafio3

class User(var user: String, var pw: String) {

    var userName: String = user
    var passWord: String = pw

    fun verifyUser (aUser: String, aPass: String): Boolean {

        return (aUser == this.userName) and (aPass == this.passWord)


    }
}