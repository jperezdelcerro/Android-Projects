package com.desarrolloaplicaciones.parcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.desarrolloaplicaciones.parcial.R
import com.desarrolloaplicaciones.parcial.db.SubjectDao
import com.desarrolloaplicaciones.parcial.db.appDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_detail_subject.*


class DetailSubject : Fragment() {

    lateinit var v: View
    lateinit var name: TextView
    lateinit var s_image_view: ImageView
    lateinit var link: TextView
    lateinit var schedule: TextView
    lateinit var editBt: FloatingActionButton
    lateinit var deleteBt: FloatingActionButton


    lateinit var db: appDatabase
    lateinit var subjectDao: SubjectDao


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_detail_subject, container, false)
        name = v.findViewById(R.id.subName)
        link = v.findViewById(R.id.link)
        schedule = v.findViewById(R.id.schedule)
//      s_image_view = v.findViewById(R.id.subjectImage)
        editBt = v.findViewById(R.id.fab)
        deleteBt = v.findViewById(R.id.deleteBt)

        return v
    }


    override fun onStart() {
        super.onStart()

        //var mySub = SubjectActivityArgs.fromBundle(requireArguments()).aSub
        var mySub = DetailSubjectArgs.fromBundle(requireArguments()).aSub
        name.text = mySub.name
        link.text = mySub.link


        db = appDatabase.getAppDataBase(v.context)!!
        subjectDao = db?.subjectDao()

        editBt.setOnClickListener{

            val action = DetailSubjectDirections.actionDetailSubjectToEditSubject(mySub)
            v.findNavController().navigate(action)

        }


        deleteBt.setOnClickListener {

            Snackbar.make(v,mySub.name + " delete :(", Snackbar.LENGTH_LONG).show()
            subjectDao.delete(mySub)
            val action = DetailSubjectDirections.actionDetailSubjectToSubjectList()
            v.findNavController().navigate(action)
        }

        //text_description = myFood.description

    }
}
