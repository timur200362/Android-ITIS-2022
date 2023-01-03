package com.example.android_itis_2022

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContract
//первоначальная реализация получения изображения через камеру
//class CameraActivityResultContract: ActivityResultContract<String, Bitmap?>(){
//    override fun createIntent(context: Context, params: String) =
//        Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//
//    override fun parseResult(resultCode: Int, result: Intent?) : Bitmap? {
//        if (resultCode != Activity.RESULT_OK) {
//            return null
//        }
//        return result?.extras!!["data"] as Bitmap?
//    }
//
//}