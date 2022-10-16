package com.example.android_itis_2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.android_itis_2022.databinding.FragmentProfileDialogBinding

class ProfileFragmentDialog(val counterVal:Int,val onButtonClicked:(Int)->Unit) : DialogFragment(R.layout.fragment_profile_dialog){
    private var textValue=0
    private var binding: FragmentProfileDialogBinding?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?):View{
        binding= FragmentProfileDialogBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context,counterVal.toString(),Toast.LENGTH_LONG).show()

    }
    private fun showDialog2(){
        showDialog(
            title = "Title",
            positiveAction = {
                if (!binding!!.inputCounter.text.isNullOrBlank()){
                    textValue=Integer.valueOf(binding!!.inputCounter.text.toString())
                }
                if (check()){
                    onButtonClicked(counterVal+textValue)
                }
            },
            negativeAction = {
                if (!binding!!.inputCounter.text.isNullOrBlank()){
                    textValue=Integer.valueOf(binding!!.inputCounter.text.toString())
                }
                if(check()){
                    onButtonClicked(counterVal-textValue)
                }
            }
        )
    }
    private fun check():Boolean{
        if (!binding!!.inputCounter.text.isNullOrBlank()){
            textValue=Integer.valueOf(binding!!.inputCounter.text.toString())
            if(!(textValue in 0..100)){
                binding!!.inputLayout.error="The value should range from 0 to 100"
                return false}
            else{
                binding!!.inputLayout.isErrorEnabled=false
            }
        }
        return true
    }
}