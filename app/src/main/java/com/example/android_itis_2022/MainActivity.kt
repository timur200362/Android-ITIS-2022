package com.example.android_itis_2022

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import com.example.android_itis_2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        binding?.run {
            button.setOnClickListener{
                addEvent("Birthday","Home");
            }
            button2.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("geo:0,0?q=Хусаина Ямашева+115А")
                }
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
            button3.setOnClickListener{
                openWebPage("https://www.google.ru/")
            }
        }
    }


    fun addEvent(title: String, location: String) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, title)
            putExtra(CalendarContract.Events.EVENT_LOCATION, location)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}