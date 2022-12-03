package com.example.android_itis_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.android_itis_2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var controller:NavController
    private var binding:ActivityMainBinding?=null

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater).also{
            setContentView(it.root)
        }
        controller=(supportFragmentManager.findFragmentById(R.id.container) as NavHostController).navController

        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(R.id.servicesFragment2),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
//        binding?.run {
//            bnvMain.setupWithNavController(controller)
//        }
    }
}