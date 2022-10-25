package com.example.android_itis_2022

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_itis_2022.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private var binding: ActivitySecondBinding? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        val intent = intent

        val uri = intent.getStringExtra(Intent.EXTRA_TEXT)
        binding?.textView2?.setText(uri)
    }
}
