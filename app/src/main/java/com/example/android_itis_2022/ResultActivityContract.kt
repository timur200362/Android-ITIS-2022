package com.example.android_itis_2022

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapFactory.decodeStream
import android.net.Uri
import android.os.Parcelable
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContract

class ResultActivityContract(private val context: Context): ActivityResultContract<String, Bitmap?>(){
    override fun createIntent(context: Context, params: String): Intent {
        val galleryIntent = Intent().apply {
            action = android.content.Intent.ACTION_PICK;
            type = "image/*";
        }
        val chooserIntent=Intent.createChooser(galleryIntent,"Gallery")
        val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(cameraIntent))
        return chooserIntent
    }

    override fun parseResult(resultCode: Int, result: Intent?) : Bitmap? {
        if (resultCode != Activity.RESULT_OK) {
            return null
        }
        val bitmap = result.takeIf { resultCode == Activity.RESULT_OK }
            ?.getParcelableExtra<Parcelable>("data")
        val uri = result.takeIf { resultCode == Activity.RESULT_OK }?.data
        if (bitmap != null) return bitmap as Bitmap else
            if (uri != null) return decodeStream(
                context
                    .contentResolver.openInputStream(uri)
            ) else return null
    }
}