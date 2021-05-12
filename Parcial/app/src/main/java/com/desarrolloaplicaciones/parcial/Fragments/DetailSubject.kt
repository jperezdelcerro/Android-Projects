package com.desarrolloaplicaciones.parcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.desarrolloaplicaciones.parcial.R



class DetailSubject : Fragment() {
    lateinit var v: View
    lateinit var s_name: TextView
    lateinit var s_image_view: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_detail_subject, container, false)
        s_name = v.findViewById(R.id.subName)
//        s_image_view = v.findViewById(R.id.subjectImage)

        return v
    }


    override fun onStart() {
        super.onStart()

        //var mySub = SubjectActivityArgs.fromBundle(requireArguments()).aSub
        var mySub = DetailSubjectArgs.fromBundle(requireArguments()).aSub
        s_name.text = mySub.name

        //text_description = myFood.description

    }
}
