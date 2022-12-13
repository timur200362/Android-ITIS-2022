package com.example.android_itis_2022

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.android_itis_2022.databinding.ItemGameBinding

class GameItem (
    private val binding:ItemGameBinding,
    private val glide: RequestManager,
    private val action:(Game)->Unit
): RecyclerView.ViewHolder(binding.root) {
    fun onBind(team: Game){
        with(binding){
            tvGameName.text=team.name

            glide
                .load(team.cover)
                .into(ivGamePhoto)

            root.setOnClickListener{
                action(team)
            }
        }
    }
}