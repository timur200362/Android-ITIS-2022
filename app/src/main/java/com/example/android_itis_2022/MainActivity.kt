package com.example.android_itis_2022

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_itis_2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val getContent = registerForActivityResult(ResultActivityContract(this@MainActivity)) { bitmap: Bitmap? ->
        binding?.imvImage?.setImageBitmap(bitmap)
    }

//    val getContentCamera = registerForActivityResult(CameraActivityResultContract()) { bitmap: Bitmap? ->
//        binding?.imvImage?.setImageBitmap(bitmap)
//    }

    private var binding:ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)

            it.btnGetPicture.setOnClickListener {
                getContent.launch("")
            }
        }
    }
}