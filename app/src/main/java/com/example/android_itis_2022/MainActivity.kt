package com.example.android_itis_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_itis_2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        if(savedInstanceState!=null){
            return
        }
        binding?.run {
            supportFragmentManager.beginTransaction().replace(R.id.container,ProfileFragment()).commit()
        }
    }
}