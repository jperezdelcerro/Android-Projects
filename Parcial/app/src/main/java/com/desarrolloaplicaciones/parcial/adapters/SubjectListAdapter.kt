package com.desarrolloaplicaciones.parcial.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloaplicaciones.parcial.R
import com.desarrolloaplicaciones.parcial.clases.Subject

class SubjectListAdapter(private var subjectList: MutableList<Subject>,
                         private val context: Context,
                         val onItemClick: (Subject) -> Boolean

) : RecyclerView.Adapter<SubjectListAdapter.SubHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.subject_card,parent,false)
        return (SubHolder(view))
    }

    override fun onBindViewHolder(holder: SubHolder, position: Int) {
        subjectList[position].subjectName?.let { holder.setName(it) }
        var linkImage = "https://cdn.iconscout.com/icon/free/png-512/workbook-2185031-1827413.png"
        if(subjectList[position].image != null ){

            linkImage = subjectList[position].image.toString()
        }

       /* Glide
            .with(context)
            .load(linkImage )

            .centerInside()
            .into(holder.getImage());

*/
        /* holder.getCardLayout().setOnLongClickListener() {
             //onItemClick(position)

         }*/

        holder.getButton().setOnClickListener {

            onItemClick(subjectList[position])

        }
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }



    class SubHolder (v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v

        fun setName(name: String) {
            val txt: TextView = view.findViewById(R.id.txt_name_item)
            txt.text = name
        }

        fun getCardLayout (): CardView {
            return view.findViewById(R.id.card_package_item)
        }

        fun getButton (): Button {
            return view.findViewById(R.id.button)
        }

        fun getImage(): ImageView{
            return view.findViewById(R.id.subjectImage)
        }



    }


//

}

