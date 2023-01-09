package com.example.android_itis_2022

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContract
//первоначальная реализация получения изображения через галлерею
//class GalleryActivityResultContract:ActivityResultContract<String,Uri?>(){
//    override fun createIntent(context: Context, params: String) =
//        Intent().apply {
//            action = android.content.Intent.ACTION_PICK;
//            type = "image/*";
//        }
//
//    override fun parseResult(resultCode: Int, result: Intent?) : Uri? {
//        if (resultCode != Activity.RESULT_OK) {
//            return null
//        }
//        return result?.data
//    }
//
//}