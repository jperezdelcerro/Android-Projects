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


class EditSubject : Fragment() {

    lateinit var v: View
    lateinit var name: TextView
    lateinit var s_image_view: ImageView
    lateinit var link: TextView
    lateinit var schedule: TextView
    lateinit var saveBt: Button
    lateinit var deleteBt: FloatingActionButton

    lateinit var db: appDatabase
    lateinit var subjectDao: SubjectDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_edit_subject, container, false)
        name = v.findViewById(R.id.editSubName)
        link = v.findViewById(R.id.editLink)
        schedule = v.findViewById(R.id.editSchedule)
        saveBt = v.findViewById(R.id.save_button)




        return v
    }

    override fun onStart() {
        super.onStart()

        var mySub = EditSubjectArgs.fromBundle(requireArguments()).mySub
        name.text = mySub.name
        link.text = mySub.link
        schedule.text = mySub.schedule


        db = appDatabase.getAppDataBase(v.context)!!
        subjectDao = db?.subjectDao()


        saveBt.setOnClickListener {


            mySub.name = name.text.toString()
            mySub.link = link.text.toString()
            mySub.schedule = schedule.text.toString()

            subjectDao.updatePerson(mySub)

            Snackbar.make(v,mySub.name + " already save!", Snackbar.LENGTH_LONG).show()

        }





    }
}