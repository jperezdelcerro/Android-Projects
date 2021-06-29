package com.desarrolloaplicaciones.parcial.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import com.desarrolloaplicaciones.parcial.R
import com.desarrolloaplicaciones.parcial.clases.User
import com.desarrolloaplicaciones.parcial.db.UserDao
import com.desarrolloaplicaciones.parcial.db.appDatabase
import com.google.android.material.snackbar.Snackbar


class Login : Fragment() {


    var RegisteredUsers: MutableList<User> = ArrayList<User>()

    lateinit var v: View

    lateinit var db: appDatabase
    lateinit var userDao: UserDao

    lateinit var usernameDataInput: EditText
    lateinit var passDataInput: EditText
    lateinit var goButton: Button
    lateinit var singUp: TextView
    lateinit var foundUser: User

    private val PREF_NAME = "myPreferences"




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_login, container, false)
        usernameDataInput = v.findViewById(R.id.txtUsername)
        passDataInput = v.findViewById(R.id.editTextTextPassword)
        goButton = v.findViewById(R.id.buttonLogin)
        singUp = v.findViewById(R.id.singup)
        return v
    }

    companion object {

    }
    override fun onStart() {
        super.onStart()

        //RegisteredUsers.add(User(1,"josefina","josefina"))

        db = appDatabase.getAppDataBase(v.context)!!
        userDao = db?.userDao()

        //userDao?.insertPerson(User(0,'josefina','josefina'))

        RegisteredUsers = userDao?.loadAllPersons() as MutableList<User>



        val sharedPref: SharedPreferences = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()






        goButton.setOnClickListener {


            val user = findUser(usernameDataInput.text.toString(),passDataInput.text.toString())
            if(user != null){

                editor.putInt("USERID", user.id)
                editor.apply()
                val action = LoginDirections.actionLoginToListActivity()
                v.findNavController().navigate(action)
                Snackbar.make(v,"Hi" + foundUser.username + "!", Snackbar.LENGTH_LONG).show()

            }else{

                usernameDataInput.text.clear()
                passDataInput.text.clear()
                Snackbar.make(v,"User/Password is incorrect, please try again", Snackbar.LENGTH_LONG).show()


            }



        }

        singUp.setOnClickListener{

            val action = LoginDirections.actionLoginToAddUser()
            v.findNavController().navigate(action)

        }





    }
    private fun findUser(userName: String,passWord:String): User? {


        for (user in RegisteredUsers){

            if(user.verifyUser(userName,passWord)){
                foundUser = user
                return user
            }


        }

        return null

    }
}