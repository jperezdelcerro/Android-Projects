package com.desarrolloaplicaciones.login

class User(user: String, password: String) {

    var username: String = user
    var password: String = password

    fun verifyUser (aUser: String, aPass: String): Boolean {

        return (aUser == this.username) and (aPass == this.password)


    }


}