package com.desarrolloaplicaciones.desafio3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.desarrolloaplicaciones.desafio3.Clases.Food
import com.desarrolloaplicaciones.desafio3.R
import android.content.Context
import android.widget.ImageButton

class FoodListAdapter(private var foodList: MutableList<Food>,
                      private val context: Context,
                      val onItemClick: (Food) -> Boolean

) : RecyclerView.Adapter<FoodListAdapter.FoodHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return (FoodHolder(view))
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        foodList[position].foodName?.let { holder.setName(it) }

        Glide
        .with(context)
        .load("https://firebasestorage.googleapis.com/v0/b/firestoreexample-ec489.appspot.com/o/Fotos%2FGUERNICA.jpg?alt=media&token=001a8ffc-96c2-4aeb-9120-8d5099b3fa1c")

        .centerInside()
        .into(holder.getButton());


       /* holder.getCardLayout().setOnLongClickListener() {
            //onItemClick(position)

        }*/

        holder.getButton().setOnClickListener {

            onItemClick(foodList[position])

        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }



    class FoodHolder (v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v

        fun setName(name: String) {
            val txt: TextView = view.findViewById(R.id.txt_name_item)
            txt.text = name
        }

        fun getCardLayout (): CardView {
            return view.findViewById(R.id.card_package_item)
        }

        fun getButton (): ImageButton {
            return view.findViewById(R.id.imageButton_item)
        }



    }


//

}