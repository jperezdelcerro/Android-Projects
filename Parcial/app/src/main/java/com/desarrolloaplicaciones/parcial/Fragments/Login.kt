package com.desarrolloaplicaciones.parcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.desarrolloaplicaciones.parcial.R
import com.desarrolloaplicaciones.parcial.clases.User
import com.google.android.material.snackbar.Snackbar


class Login : Fragment() {


    var RegisteredUsers: MutableList<User> = ArrayList<User>()

    lateinit var v: View
    lateinit var usernameDataInput: EditText
    lateinit var passDataInput: EditText
    lateinit var goButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_login, container, false)
        usernameDataInput = v.findViewById(R.id.editTextTextPersonName)
        passDataInput = v.findViewById(R.id.editTextTextPassword)
        goButton = v.findViewById(R.id.buttonLogin)
        return v
    }

    companion object {

    }
    override fun onStart() {
        super.onStart()

        RegisteredUsers.add(User("josefina","josefina"))

        goButton.setOnClickListener {

            var newUser = User(usernameDataInput.text.toString(),passDataInput.text.toString())
            if(findUser(newUser)){

                val action = LoginDirections.actionLoginToListActivity()
                v.findNavController().navigate(action)

            }else{

                usernameDataInput.text.clear()
                passDataInput.text.clear()
                Snackbar.make(v,"User/Password is incorrect, please try again", Snackbar.LENGTH_LONG).show()


            }



        }





    }
    private fun findUser(newUser: User): Boolean {


        for (user in RegisteredUsers){

            if(user.verifyUser(newUser.userName,newUser.passWord)){
                return true
            }


        }

        return false

    }
}