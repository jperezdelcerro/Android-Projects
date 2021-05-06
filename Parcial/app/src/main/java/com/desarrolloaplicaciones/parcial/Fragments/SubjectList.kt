package com.desarrolloaplicaciones.parcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloaplicaciones.parcial.R
import com.desarrolloaplicaciones.parcial.adapters.SubjectListAdapter
import com.desarrolloaplicaciones.parcial.clases.Subject


class SubjectList : Fragment() {
    lateinit var v: View

    lateinit var rec: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager


    var subjectList : MutableList<Subject> = ArrayList<Subject>()
    private lateinit var subjectListAdapter: SubjectListAdapter



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

        subjectList.add(Subject("Electronica Aplicada 3","https://i1.wp.com/www.electronicasi.com/wp-content/uploads/2013/02/BJT_symbol_NPN.svg_.png?fit=510%2C600"))


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


        val action = SubjectListDirections.actionSubjectListToDetailSubject(aSub)
        v.findNavController().navigate(action)
        return true
    }


}
