package com.example.android_itis_2022

import androidx.recyclerview.widget.RecyclerView
import com.example.android_itis_2022.databinding.ItemPlanetsBinding

class PlanetsItem(
    private val binding: ItemPlanetsBinding,
    private val action:(Planets)->Unit
): RecyclerView.ViewHolder(binding.root) {
    fun onBind(planets: Planets){
        with(binding){
            tvTitle.text=planets.name
            tvTitle2.text=planets.descriptionPlanet

            root.setOnClickListener{
                action(planets)
            }
        }
    }
}