package com.example.android_itis_2022

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_itis_2022.databinding.ItemPlanetsBinding

class PlanetsAdapter(
    private val list:List<Planets>,
    private val action:(Planets)->Unit
): RecyclerView.Adapter<PlanetsItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanetsItem= PlanetsItem(
        ItemPlanetsBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    ),
        action)

    override fun onBindViewHolder(
        holder: PlanetsItem,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int=list.size
}