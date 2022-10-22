package com.example.android_itis_2022

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
        val binding = FragmentProfileDialogBinding.inflate(layoutInflater)
        builder.setView(binding.root)
//        binding.inputCounter.addTextChangedListener(object:TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                if (s.toString().toInt()>100){
//                    binding.inputCounter.setError("Invalid value entered")
//                }
//            }
//        })
        builder.setPositiveButton("OK") { _, _ ->
            if (binding.inputCounter.text.toString().toInt()>100 && binding.inputCounter.text.toString().toInt()<0){
                binding.inputCounter.setError("Invalid value entered")
            }
            else{
                plus?.invoke(Integer.valueOf(binding.inputCounter.text.toString()))
            }
        }
        builder.setNegativeButton("Cancel"
        ) { dialog, _ -> dialog.dismiss() }
        builder.setNeutralButton("Neutrial"
        ) { _, _ ->
            if (binding.inputCounter.text.toString().toInt()>100 && binding.inputCounter.text.toString().toInt()<0){
                binding.inputCounter.setError("Invalid value entered")
            }
            else{
                minus?.invoke(Integer.valueOf(binding.inputCounter.text.toString()))
            }
        }
        return builder.create()
    }
}