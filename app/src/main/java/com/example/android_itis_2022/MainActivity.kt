package com.example.android_itis_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_itis_2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding?=null
    private var adapter:PlanetsAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding=ActivityMainBinding.inflate(layoutInflater).also{
            setContentView(it.root)
        }
        binding?.run{
            adapter=PlanetsAdapter(PlanetsRepository.planets){
                root.showSnackbar("You click:${it.name}")
            }
            rvPlanets.adapter=adapter
            rvPlanets.layoutManager= LinearLayoutManager(this@MainActivity)
        }
    }
}