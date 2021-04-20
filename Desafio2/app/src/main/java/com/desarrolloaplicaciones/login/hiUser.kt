package com.desarrolloaplicaciones.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class HiUser : Fragment() {

    lateinit var v: View
    lateinit var helloText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_hi_user, container, false)
        helloText = v.findViewById(R.id.helloText)
        return v

    }

    companion object {

    }

    override fun onStart() {
        super.onStart()

        var username = HiUserArgs.fromBundle(requireArguments()).aUser

        helloText.text = "Helllo " + username + "!!"



    }
}