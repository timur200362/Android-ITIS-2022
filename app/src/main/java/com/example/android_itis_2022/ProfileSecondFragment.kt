package com.example.android_itis_2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_itis_2022.databinding.FragmentProfileSecondBinding

class ProfileSecondFragment : Fragment() {
    private var binding:FragmentProfileSecondBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentProfileSecondBinding.inflate(inflater,container,false).let{
            binding=it
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val counterValue=arguments?.getInt(ProfileFragment2_TAG)?:0
        var colorValue=0
        with(binding){
            when(counterValue){
                 in 0..50->{
                    colorValue=resources.getIntArray(R.array.colors_array).get(0)
                }
                in 51..100->{
                    colorValue=resources.getIntArray(R.array.colors_array).get(1)
                }
                in 101..Int.MAX_VALUE->{
                    colorValue=resources.getIntArray(R.array.colors_array).get(2)
                }
            }
            this?.colorCounterValue?.text = "$counterValue"
            this?.screenSecond?.setBackgroundColor(colorValue)
        }
    }
    companion object {
        const val ProfileFragment2_TAG = "ProfileFragment2_TAG"
        fun getInstance(count: Int) = ProfileSecondFragment().apply {
            arguments=Bundle().apply {
                putInt(ProfileFragment2_TAG,count)
            }
        }
    }
}