package com.aplikasi.bitasteapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.bitasteapp.data.Food
import com.aplikasi.bitasteapp.R
import com.aplikasi.bitasteapp.databinding.ItemListBinding
import com.bumptech.glide.Glide


class MainAdapter (private val food: ArrayList<Food>):RecyclerView.Adapter<MainAdapter.ViewHolder>(){
    class ViewHolder(var binding: ItemListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(food: Food){
            Glide.with(itemView).load(food.image).into(binding.ivMenu)
            binding.tvNamaMakanan.text=food.name
            binding.tvPriceFood.text=food.price
            binding.tvRating.text = food.rating.toString()      }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(food[position])
        var nama = food[position]
        holder.binding.ivMenu.setOnClickListener {
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