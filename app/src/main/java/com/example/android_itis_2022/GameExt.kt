package com.example.android_itis_2022

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(
    text:String,
    length:Int=Snackbar.LENGTH_LONG
){
    Snackbar.make(this,text,length).show()
}