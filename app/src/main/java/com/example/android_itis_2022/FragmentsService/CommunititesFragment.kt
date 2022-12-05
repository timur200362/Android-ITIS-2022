package com.example.android_itis_2022.FragmentsService

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android_itis_2022.R
import com.example.android_itis_2022.databinding.FragmentCommunititesBinding
import com.example.android_itis_2022.databinding.FragmentServicesBinding

class CommunititesFragment : Fragment() {
    private var binding: FragmentCommunititesBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_communitites, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentCommunititesBinding.bind(view)

        binding?.run {
            btnGoToFriends.setOnClickListener{
                findNavController().navigate(R.id.action_communititesFragment_to_friendsFragment)
            }
        }
    }
}