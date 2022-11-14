package com.example.android_itis_2022.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.android_itis_2022.Model.Game
import com.example.android_itis_2022.Model.MainItem
import com.example.android_itis_2022.databinding.ItemGameBinding

class GameItem(
    private val actionDelete:(Game)->Unit,
    private val binding:ItemGameBinding,
    private val glide: RequestManager,
    private val action: (Game) -> Unit
): RecyclerView.ViewHolder(binding.root) {
    fun onBind(game: Game){
        with(binding){
            tvGameName.text=game.name

            glide
                .load(game.cover)
                .into(ivGamePhoto)

            root.setOnClickListener{
                action(game)
            }
            deleteGame.setOnClickListener{
                actionDelete(game)
            }
        }
    }
    companion object{
        const val ARG_NAME="arg_name"

        fun create(
            parent:ViewGroup,
            glide:RequestManager,
            action: (Game) -> Unit,
            actionDelete: (Game) -> Unit
        ):GameItem= GameItem(
            binding = ItemGameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide =glide,
            action =action,
            actionDelete =actionDelete
        )
    }
}