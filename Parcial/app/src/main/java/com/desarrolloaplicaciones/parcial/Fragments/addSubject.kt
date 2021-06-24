package com.desarrolloaplicaciones.parcial.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.desarrolloaplicaciones.parcial.R
import com.desarrolloaplicaciones.parcial.clases.Subject
import com.desarrolloaplicaciones.parcial.clases.User
import com.desarrolloaplicaciones.parcial.db.SubjectDao
import com.desarrolloaplicaciones.parcial.db.UserDao
import com.desarrolloaplicaciones.parcial.db.appDatabase
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_add_subject.*


class addSubject : Fragment() {

    lateinit var v: View

    lateinit var db: appDatabase
    lateinit var subjectDao: SubjectDao

    private lateinit var button: Button
    private lateinit var nameIp: EditText
    private lateinit var linkIp: EditText
    private lateinit var scheduleIp:EditText

    private val PREF_NAME = "myPreferences"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_add_subject, container, false)
        button = v.findViewById(R.id.add_button)
        nameIp = v.findViewById(R.id.subName)
        linkIp = v.findViewById(R.id.link)
        scheduleIp = v.findViewById(R.id.schedule)
        return v
    }

    fun checkIsFill(anEditText: EditText,anString: String): Boolean {

        if (TextUtils.isEmpty(anEditText.text.toString())) {


            Snackbar.make(v, anString, Snackbar.LENGTH_LONG).show()
            return false

        }
        return true
    }



    override fun onStart() {
        super.onStart()


        db = appDatabase.getAppDataBase(v.context)!!
        subjectDao = db?.subjectDao()

        button.setOnClickListener{

            if(checkIsFill(nameIp,"Subject must have a name")){

                Snackbar.make(v,nameIp.text.toString() + " added!", Snackbar.LENGTH_LONG).show()


                val sharedPref: SharedPreferences = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
                val userId = sharedPref.getInt("USERID",0)!!


                subjectDao.insertPerson(Subject(0,userId,nameIp.text.toString(),linkIp.text.toString(),scheduleIp.text.toString()))

                nameIp.text.clear()
                linkIp.text.clear()
                scheduleIp.text.clear()


            }
        }








    }
}