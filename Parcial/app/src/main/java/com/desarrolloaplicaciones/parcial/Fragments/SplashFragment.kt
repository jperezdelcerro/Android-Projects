package com.desarrolloaplicaciones.parcial.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.desarrolloaplicaciones.parcial.R
import com.desarrolloaplicaciones.parcial.activities.MainActivity


class SplashFragment : Fragment() {

    lateinit var v: View
    private val SPLASH_TIME_OUT:Long = 3000 // 3 sec



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment_splash, container, false)

        Handler().postDelayed(

            {

                val action = SplashFragmentDirections.actionSplashFragmentToLogin()
                v.findNavController().navigate(action)

            }
            , SPLASH_TIME_OUT)


        return v
    }
    
}