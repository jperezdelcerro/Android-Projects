package com.desarrolloaplicaciones.parcial.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.desarrolloaplicaciones.parcial.R
import com.desarrolloaplicaciones.parcial.clases.User
import com.desarrolloaplicaciones.parcial.db.UserDao
import com.desarrolloaplicaciones.parcial.db.appDatabase
import com.google.android.material.snackbar.Snackbar


class AddUser : Fragment() {

    lateinit var v: View

    lateinit var db: appDatabase
    lateinit var userDao: UserDao

    lateinit var userName: EditText
    lateinit var email: EditText
    lateinit var pw1: EditText
    lateinit var pw2: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_add_user, container, false)
        return v
    }

    fun checkIsFill(anEditText: EditText,anString: String): Boolean {

        if(TextUtils.isEmpty(anEditText.text.toString())){


            Snackbar.make(v,anString, Snackbar.LENGTH_LONG).show()
            return false

        }
        return true

    }

    override fun onStart() {
        super.onStart()

        userName = v.findViewById(R.id.txtUsername)
        pw1 = v.findViewById(R.id.txtPw1)
        pw2 = v.findViewById(R.id.txtPw2)
        email = v.findViewById(R.id.txtEmail)
        button = v.findViewById(R.id.buttonConfirm)

        db = appDatabase.getAppDataBase(v.context)!!
        userDao = db?.userDao()


        button.setOnClickListener{

            if(checkIsFill(userName,"You should choose an Username") and
            checkIsFill(email,"You must put an email adress") and
            checkIsFill(pw1,"You didn't choose a password") and
            checkIsFill(pw2,"You must repeat your password")){

                if(checkPw(pw1,pw2)){

                    //chequeo de si esta en la base el email o el username
                    Snackbar.make(v,"Great! Welcome aboard!", Snackbar.LENGTH_LONG).show()

                    userDao?.insertPerson(User(0, userName.text.toString(), pw1.text.toString()))

                    userName.text.clear()
                    pw1.text.clear()
                    pw2.text.clear()
                    email.text.clear()



                }else{

                    Snackbar.make(v,"Passwords must match", Snackbar.LENGTH_LONG).show()
                    pw1.text.clear()
                    pw2.text.clear()

                }

            }



        }

    }

    private fun checkPw(pw1: EditText?, pw2: EditText?): Boolean {

        return pw1!!.text.toString() == pw2!!.text.toString()


    }


}