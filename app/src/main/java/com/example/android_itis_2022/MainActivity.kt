package com.example.android_itis_2022

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.android_itis_2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val getContent = registerForActivityResult(ResultActivityContract(this@MainActivity)) { bitmap: Bitmap? ->
        binding?.imvImage?.setImageBitmap(bitmap)
    }

    private var binding:ActivityMainBinding?=null
    private val locationPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val chooserIntent= Intent(Intent.ACTION_PICK).apply {
            type = "image/*"
        }
        val cameraIntent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(cameraIntent))

        binding= ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)

            it.btnGetPicture.setOnClickListener {
                when {
                    ContextCompat.checkSelfPermission(
                        this@MainActivity,
                        android.Manifest.permission.CAMERA
                    ) == PackageManager.PERMISSION_GRANTED -> {
                        getContent.launch(chooserIntent.toString())
                    }
                    ActivityCompat.shouldShowRequestPermissionRationale(
                        this@MainActivity,
                        android.Manifest.permission.CAMERA
                    ) -> {
                        Toast.makeText(this@MainActivity, "required permission", Toast.LENGTH_LONG)
                            .show()
                        locationPermissionLauncher.launch(
                            android.Manifest.permission.CAMERA
                        )
                        getContent.launch(chooserIntent.toString())
                    }
                    else -> {
                        locationPermissionLauncher.launch(
                            android.Manifest.permission.CAMERA
                        )
                        getContent.launch(chooserIntent.toString())
                    }
                }
                //getContent.launch("")
            }
        }
    }
}