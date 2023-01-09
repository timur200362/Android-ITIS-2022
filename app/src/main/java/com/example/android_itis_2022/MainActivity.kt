package com.example.android_itis_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.android_itis_2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide();
        binding=ActivityMainBinding.inflate(layoutInflater).also{
            setContentView(it.root)
        }
        //val binding=binding!!
        //with(binding)
        binding?.run {
            button.setOnClickListener{
                imageView2.visibility=if (imageView2.visibility==View.GONE){
                    View.VISIBLE
                } else{
                    View.GONE
                }
            }
        }
    }
}