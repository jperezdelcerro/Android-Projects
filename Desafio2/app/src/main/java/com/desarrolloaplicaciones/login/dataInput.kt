package com.desarrolloaplicaciones.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar


class DataInput : Fragment() {

    lateinit var usernameDataInput: EditText
    lateinit var passDataInput: EditText
    lateinit var goButton: Button

     var RegisteredUsers: MutableList<User> = ArrayList<User>()

    lateinit var v: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_data_input, container, false)
        usernameDataInput = v.findViewById(R.id.editUsernameText)
        passDataInput = v.findViewById(R.id.editPasswordText)
        goButton = v.findViewById(R.id.goButton)
        return v
    }

    override fun onStart() {
        super.onStart()

        RegisteredUsers.add(User("josefina","josefina123"))

        goButton.setOnClickListener {

            var newUser = User(usernameDataInput.text.toString(),passDataInput.text.toString())
            if(findUser(newUser)){

                val action = DataInputDirections.actionDataInputToHiUser(newUser.username)
                v.findNavController().navigate(action)

            }else{

                usernameDataInput.text.clear()
                passDataInput.text.clear()
                Snackbar.make(v,"User/Password is incorrect, please try again", Snackbar.LENGTH_LONG).show()


            }



        }




    }

    private fun findUser(newUser: User): Boolean {

        var bool = false
        for (user in RegisteredUsers){

            if(user.verifyUser(newUser.username,newUser.password)){
                bool = true
            }


        }

        return bool

    }
}