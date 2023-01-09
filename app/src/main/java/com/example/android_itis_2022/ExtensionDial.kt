package com.example.android_itis_2022

import android.app.AlertDialog
import androidx.fragment.app.Fragment

typealias  Click=()->Unit

fun Fragment.showDialog(
    title:String="Dialog",
    positiveAction:Click={},
    negativeAction:Click={},
    neutralAction:Click={},
){
    AlertDialog.Builder(requireContext())
        .setTitle(title)
        .setPositiveButton("Increase"){dialog, _ ->
            positiveAction()
            dialog.dismiss()
        }
        .setNegativeButton("Close"){dialog, _ ->
            negativeAction()
            dialog.dismiss()
        }
        .setNeutralButton("Decrease"){dialog, _ ->
            neutralAction()
            dialog.dismiss()
        }
        .show()
}