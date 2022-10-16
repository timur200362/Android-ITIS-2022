package com.example.android_itis_2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_itis_2022.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var binding: FragmentProfileBinding?=null
    private var count=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentProfileBinding.inflate(inflater,container,false).let{
            binding=it
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentProfileBinding.bind(view)
        //binding?.counter?.text=count.toString()
        binding?.run {
            binding?.button1?.setOnClickListener{
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out,
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                    )
                    .replace(R.id.container, ProfileFragment2.getInstance(arguments),ProfileFragment2.ProfileFragment2_TAG)
                    .addToBackStack(null)
                    .commit()
            }
            binding?.button2?.setOnClickListener{
                count += 1
                binding?.counter?.text=count.toString()
            }
        }
    }
    companion object {
        const val ProfileFragment_TAG = "ProfileFragment_TAG"
        fun getInstance(bundle: Bundle?): ProfileFragment {
            val firstFragment = ProfileFragment()
            firstFragment.arguments = bundle
            return firstFragment
        }
    }
}