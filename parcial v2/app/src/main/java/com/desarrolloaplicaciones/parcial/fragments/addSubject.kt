package com.desarrolloaplicaciones.parcial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.desarrolloaplicaciones.parcial.R


class addSubject : Fragment() {

    lateinit var v: View
    private lateinit var button: Button
    private lateinit var nameIp: EditText
    private lateinit var linkIp: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_add_subject, container, false)
        return v
    }


    override fun onStart() {
        super.onStart()

        button = v.findViewById(R.id.settings_button)


        button.setOnClickListener(){

            var action = addSubjectDirections.actionAddSubjectToSettingsActivity2()
            v.findNavController().navigate(action)

        }




    }
}