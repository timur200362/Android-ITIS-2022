package com.example.android_itis_2022

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.android_itis_2022.databinding.ItemGameBinding

class GameAdapter(
    private val list:List<Game>,
    private val glide:RequestManager,
    private val action:(Game)->Unit
):RecyclerView.Adapter<GameItem>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameItem=
        GameItem(binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context),
        parent,
        false),
            glide=glide,
            action=action
        )

    override fun onBindViewHolder(holder: GameItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int=list.size
}