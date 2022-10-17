package com.example.android_itis_2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_itis_2022.databinding.FragmentProfileBinding
import com.example.android_itis_2022.databinding.FragmentProfileSecondBinding

class ProfileSecondFragment : Fragment() {
    private var binding:FragmentProfileSecondBinding?=null
    private var colorValue=0
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
        val counterValue=arguments?.get(ValueCounter.CON_KEY)?:0
        with(binding){
            when(counterValue){
                in 0..50->{
                    colorValue=resources.getIntArray(R.array.colors_array).get(0)
                }
                in 51..100->{
                    colorValue=resources.getIntArray(R.array.colors_array).get(1)
                }
                in 101..1000->{
                    colorValue=resources.getIntArray(R.array.colors_array).get(2)
                }
            }
            this!!.colorCounterValue?.setText("Counter value:${counterValue}")
        }
    }
    companion object {
        const val ProfileFragment2_TAG = "ProfileFragment2_TAG"
        fun getInstance(bundle: Bundle?): ProfileSecondFragment {
            val secondFragment = ProfileSecondFragment()
            secondFragment.arguments = bundle
            return secondFragment
        }
    }
}