package com.example.android_itis_2022

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.android_itis_2022.databinding.FragmentAddToListDialogBinding

class AddToListDialogFragment : DialogFragment(R.layout.fragment_add_to_list_dialog){
    var add:((Int,Game)->Unit)?=null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = "Dialog"
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setTitle(title)
        val binding = FragmentAddToListDialogBinding.inflate(layoutInflater)
        builder.setView(binding.root)

        builder.setPositiveButton("OK") { _, _ ->
            val position=binding.inputPosition.text.toString().toInt()
            val id=binding.inputId.text.toString()
            val name=binding.inputName.text.toString()
            val releaseDate=binding.inputReleaseDate.text.toString()
            val descriptionGame=binding.inputDescriptionGame.text.toString()
            val cover=binding.inputCover.text.toString()
            val game=Game(id,name,releaseDate,descriptionGame,cover)
            add?.invoke(position,game)
        }
        builder.setNegativeButton("Cancel"
        ) { dialog, _ -> dialog.dismiss() }
        return builder.create()
    }
}