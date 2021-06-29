package com.desarrolloaplicaciones.parcial.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloaplicaciones.parcial.R
import com.desarrolloaplicaciones.parcial.adapters.SubjectListAdapter
import com.desarrolloaplicaciones.parcial.clases.Subject
import com.desarrolloaplicaciones.parcial.clases.User
import com.desarrolloaplicaciones.parcial.db.SubjectDao
import com.desarrolloaplicaciones.parcial.db.appDatabase


class SubjectList : Fragment() {

    lateinit var v: View

    lateinit var db: appDatabase
    lateinit var subjectDao: SubjectDao

    lateinit var rec: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager


    var subjectList : MutableList<Subject> = ArrayList<Subject>()
    private lateinit var subjectListAdapter: SubjectListAdapter

    private val PREF_NAME = "myPreferences"




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment_subject_list, container, false)
        rec = v.findViewById(R.id.rec_subjects)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()

        db = appDatabase.getAppDataBase(v.context)!!
        subjectDao = db?.subjectDao()

        subjectList.clear()


        val sharedPref: SharedPreferences = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val userId = sharedPref.getInt("USERID",0)!!
        for( sub in subjectDao?.loadAllPersons() as MutableList<Subject>){

            if (sub.userId == userId) {
               subjectList.add(sub)
            }
        }


        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())

        when (prefs.getString("text_key","")) {
                "atoz" -> subjectList.sortBy { it.name }
                "ztoa" -> subjectList.sortByDescending { it.name }

            }

        //subjectList.add(Subject(1,1,"Electronica Aplicada 3","https://i1.wp.com/www.electronicasi.com/wp-content/uploads/2013/02/BJT_symbol_NPN.svg_.png?fit=510%2C600"))


        rec.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        rec.layoutManager = linearLayoutManager

        subjectListAdapter = context?.let {
            SubjectListAdapter(subjectList, it) { x ->
                onItemClick(x)
            }
        }!!

        //  mascotasListAdapter = MascotaListAdapter(mascotas)

        rec.adapter = subjectListAdapter

    }

    fun onItemClick ( aSub : Subject) : Boolean {

        //val action = SubjectListDirections.actionSubjectListToSubjectActivity(aSub)
        val action = SubjectListDirections.actionSubjectListToDetailSubject(aSub)
        v.findNavController().navigate(action)
        return true

    }


}
