package com.example.android_itis_2022

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.android_itis_2022.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*


class MainActivity : AppCompatActivity() {
    val getContent = registerForActivityResult(ResultActivityContract(this@MainActivity)) { bitmap: Bitmap? ->
        binding?.imvImage?.setImageBitmap(bitmap)
    }

    private var binding:ActivityMainBinding?=null
    private val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            granted ->
        if (granted)
        {
            getContent.launch("")
        }
        else
        {
            Toast.makeText(this@MainActivity,"Нужно разрешение!",Toast.LENGTH_LONG).show()
        }
    }


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
                        showPermsOnSetting()
                    }
                    else -> {
                        permissionLauncher.launch(
                            android.Manifest.permission.CAMERA
                        )
                    }
                }
            }
        }
    }
    fun showPermsOnSetting() {
        binding?.root?.let {
            Snackbar.make(
                it,
                getString(R.string.storage_permissions_not_granted),
                Snackbar.LENGTH_LONG
            )
                .setAction(
                    getString(R.string.settings).uppercase(Locale.getDefault())
                ) { v: View? -> openApplicationSettings() }
                .show()
        }
    }

    private fun openApplicationSettings() {
        val appSettingsIntent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.parse("package:" + this.getPackageName())
        )
        startActivityForResult(appSettingsIntent, 1)
    }

}