package com.desarrolloaplicaciones.desafio3.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.desarrolloaplicaciones.desafio3.R


class ListDetail : Fragment() {


    lateinit var v: View
    lateinit var text_name: TextView
    lateinit var text_price: TextView
    lateinit var text_description: TextView
    lateinit var image_view: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_list_detail, container, false)
        text_name = v.findViewById(R.id.textView_name)
        text_description = v.findViewById(R.id.textView_description)
        text_price = v.findViewById(R.id.textView_price)
        image_view = v.findViewById(R.id.imageView)



        return v
    }


    override fun onStart() {
        super.onStart()

        var myFood = ListDetailArgs.fromBundle(requireArguments()).aFood
        text_name.text = myFood.name
        text_price.text = myFood.price.toString()
        //text_description = myFood.description

    }
    companion object {

    }
}