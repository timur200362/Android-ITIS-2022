package com.example.android_itis_2022

import androidx.recyclerview.widget.RecyclerView
import com.example.android_itis_2022.databinding.ItemGameBinding

class GameItem (private val binding:ItemGameBinding,
                private val action:(Game)->Unit
): RecyclerView.ViewHolder(binding.root) {
    fun onBind(team: Game){
        with(binding){
            tvGameName.text=team.name

            root.setOnClickListener{
                action(team)
            }
        }
    }
}