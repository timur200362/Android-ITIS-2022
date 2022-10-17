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
        builder.setPositiveButton("OK") { _, _ ->
            plus?.invoke(Integer.valueOf(binding.inputCounter.text.toString()))
        }
        builder.setNegativeButton("Cancel"
        ) { dialog, _ -> dialog.dismiss() }
        builder.setNeutralButton("Neutrial"
        ) { _, _ ->
                minus?.invoke(Integer.valueOf(binding.inputCounter.text.toString()))
        }
        return builder.create()
    }
}