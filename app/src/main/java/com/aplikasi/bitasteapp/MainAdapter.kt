package com.aplikasi.bitasteapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.bitasteapp.databinding.ItemListBinding.inflate
import com.aplikasi.bitasteapp.databinding.ItemListBinding
import com.bumptech.glide.Glide

class MainAdapter (private val food: ArrayList<Food>):RecyclerView.Adapter<MainAdapter.ListViewHolder>(){
    inner class ListViewHolder (private val binding: ItemListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(food: Food){
            Glide.with(itemView).load(food.image).into(binding.ivMenu)
            binding.tvNamaMakanan.text=food.name
            binding.tvPriceFood.text=food.price
            binding.tvRating.text= food.rating.toString()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
        ):MainAdapter.ListViewHolder= ListViewHolder(inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int= food.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) = holder.bind(food[position])

}