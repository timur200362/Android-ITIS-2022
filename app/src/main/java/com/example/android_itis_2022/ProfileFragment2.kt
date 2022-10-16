package com.example.android_itis_2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ProfileFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile2, container, false)
    }
    companion object {
        const val ProfileFragment2_TAG = "ProfileFragment2_TAG"
        fun getInstance(bundle: Bundle?): ProfileFragment2 {
            val secondFragment = ProfileFragment2()
            secondFragment.arguments = bundle
            return secondFragment
        }
    }
}