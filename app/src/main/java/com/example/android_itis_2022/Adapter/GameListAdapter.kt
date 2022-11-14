package com.example.android_itis_2022.Adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.example.android_itis_2022.Model.Game
import com.example.android_itis_2022.Model.GameRepository
import com.example.android_itis_2022.Model.MainItem
import com.example.android_itis_2022.databinding.ItemGameBinding

class GameListAdapter(
    private val glide: RequestManager,
    private val action:(Game)->Unit,
    private val actionDelete:(Game)->Unit
): ListAdapter<Game,GameItem>(
    object:DiffUtil.ItemCallback<Game>(){
        override fun areItemsTheSame(
            oldItem: Game,
            newItem: Game
        ): Boolean=oldItem.id==newItem.id

        override fun areContentsTheSame(
            oldItem: Game,
            newItem: Game
        ): Boolean=oldItem.id==newItem.id

        override fun getChangePayload(
            oldItem: Game,
            newItem: Game
        ): Any? {
            val bundle=Bundle()
            if(oldItem.name!=newItem.name){
                bundle.putString(GameItem.ARG_NAME,newItem.name)
            }
            return if(bundle.isEmpty) super.getChangePayload(oldItem, newItem) else bundle
        }
    }
){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): GameItem=GameItem.create(parent,glide,action,actionDelete)

    override fun onBindViewHolder(holder: GameItem, position: Int) {
        holder.onBind(getItem(position))
    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameItem =
//        GameItem(
//            binding = ItemGameBinding.inflate(
//            LayoutInflater.from(parent.context),
//            parent,
//            false),
//            glide =glide,
//            action =action
//        )
//
//    override fun onBindViewHolder(holder: GameItem, position: Int) {
//        holder.onBind(list[position])
//    }
//
//    override fun getItemCount(): Int=list.size
}