package com.aplikasi.bitasteapp.Adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.bitasteapp.Data.Food
import com.aplikasi.bitasteapp.R
import com.aplikasi.bitasteapp.databinding.ItemListDownBinding

import com.bumptech.glide.Glide

class ListAdapter (private val food: ArrayList<Food>): RecyclerView.Adapter<ListAdapter.ViewHolder>(){
    class ViewHolder(var binding: ItemListDownBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(food: Food){
            Glide.with(itemView).load(food.image).into(binding.ivMenuImg)
            binding.tvMenuName.text=food.name
            binding.tvMenuPrice.text=food.price
            binding.tvRatingList.text = food.rating.toString()      }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListDownBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(food[position])
        var nama = food[position]
        holder.binding.listMenu.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("namaMenu", nama.name)
            bundle.putString("hargaMenu", nama.price)
            bundle.putDouble("rating", nama.rating)
            bundle.putInt("gambar", nama.image)
            bundle.putString("loc", nama.location)
            bundle.putString("description", nama.description)
            Navigation.findNavController(it).navigate(R.id.action_fragmentHome_to_fragmentDetailMenu2, bundle)
        }
    }

    override fun getItemCount(): Int {
        return food.size
    }
}