package com.example.android_itis_2022.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.android_itis_2022.R
import com.example.android_itis_2022.databinding.FragmentServicesBinding

class ServicesFragment : Fragment() {
    private var binding:FragmentServicesBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_services, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentServicesBinding.bind(view)

        val options = navOptions {
            launchSingleTop = false
            popUpTo(R.id.servicesFragment) {
                inclusive = true
            }
            anim {
                enter = android.R.anim.slide_out_right
                exit = android.R.anim.slide_in_left
            }
        }



        binding?.run {
            btnGoToCommunitites.setOnClickListener{
                findNavController().navigate(R.id.action_servicesFragment_to_nested_graph,null,options)
            }
        }
    }
}