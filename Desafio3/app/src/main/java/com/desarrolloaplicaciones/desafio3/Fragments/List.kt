package com.desarrolloaplicaciones.desafio3.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desarrolloaplicaciones.desafio3.Adapter.FoodListAdapter
import com.desarrolloaplicaciones.desafio3.Clases.Food
import com.desarrolloaplicaciones.desafio3.R


class List : Fragment() {
    lateinit var v: View

    lateinit var recFood: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager


    var food : MutableList<Food> = ArrayList<Food>()
    private lateinit var foodListAdapter: FoodListAdapter

    companion object {
        fun newInstance() = List()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment_list, container, false)
        recFood = v.findViewById(R.id.rec_food)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()

        food.add(Food("Milanesa c/ fritas",1800))
        food.add(Food("Pizza",545))
        food.add(Food("Empanada de carne",160))

        recFood.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recFood.layoutManager = linearLayoutManager

        foodListAdapter = context?.let {
            FoodListAdapter(food, it) { x ->
                onItemClick(x)
            }
        }!!

        //  mascotasListAdapter = MascotaListAdapter(mascotas)

        recFood.adapter = foodListAdapter

    }

    fun onItemClick ( aFood : Food) : Boolean {


        val action = ListDirections.actionListToListDetail(aFood)
        v.findNavController().navigate(action)
        return true
    }


}