package com.example.android_itis_2022

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.android_itis_2022.databinding.FragmentProfileDialogBinding


class ProfileDialogFragment : DialogFragment(R.layout.fragment_profile_dialog){

    var plus: ((Int) -> Unit)? = null
    var minus: ((Int) -> Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = "Dialog"
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setTitle(title)
        val binding= FragmentProfileDialogBinding.inflate(layoutInflater)
        builder.setView(binding.root)
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
//            if (!binding.inputCounter.text.isNullOrBlank()){
//                textValue=Integer.valueOf(binding.inputCounter.text.toString())
//            }
//            if (check(binding)){
//                onButtonClicked(counter+textValue)
//            }
            plus?.invoke(Integer.valueOf(binding.inputCounter.text.toString()))
        })
        builder.setNegativeButton("Cancel"
        ) { dialog, _ -> dialog.dismiss() }
        builder.setNeutralButton("Neutrial"
        ) { _, _ ->
//            if (!binding.inputCounter.text.isNullOrBlank()) {
//                textValue = Integer.valueOf(binding.inputCounter.text.toString())
//            }
//            if (check(binding)) {
//                onButtonClicked(counter - textValue)
//            }
                minus?.invoke(Integer.valueOf(binding.inputCounter.text.toString()))
        }
        return builder.create()
    }

//    private fun check(binding:FragmentProfileDialogBinding):Boolean{
//        if (!binding.inputCounter.text.isNullOrBlank()){
//            textValue=Integer.valueOf(binding.inputCounter.text.toString())
//            if(!(textValue in 0..100)){
//                binding.inputLayout.error="The value should range from 0 to 100"
//                return false}
//            else{
//                binding.inputLayout.isErrorEnabled=false
//            }
//        }
//        return true
//    }
}