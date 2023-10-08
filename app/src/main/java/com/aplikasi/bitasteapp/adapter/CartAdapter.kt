package com.aplikasi.bitasteapp.adapter

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.bitasteapp.R
import com.aplikasi.bitasteapp.data.SetViewModel
import com.aplikasi.bitasteapp.data.room.FoodDatabase
import com.aplikasi.bitasteapp.data.room.RoomEntity
import com.aplikasi.bitasteapp.databinding.ItemListCartBinding
import com.bumptech.glide.Glide
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class CartAdapter(var listData: List<RoomEntity>): RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    var dbFood: FoodDatabase? = null
    var plusCount : ((RoomEntity)->Unit)? = null
    var minCount : ((RoomEntity)->Unit)? = null
    class ViewHolder(var binding: ItemListCartBinding): RecyclerView.ViewHolder(binding.root){
        fun getData(itemData: RoomEntity){
            binding.tvMenuPriceCart.text = itemData.harga
            binding.tvMenuNameCart.text = itemData.namaFood
            Glide.with(itemView).load(itemData.poto).into(binding.ivMenuCartImg)
            binding.number.text = itemData.stock.toString()
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.ViewHolder {
        var view = ItemListCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: CartAdapter.ViewHolder, position: Int) {
        holder.getData(listData[position])
        holder.binding.btnMinus.setOnClickListener {
            val num = holder.binding.number.text.toString().toInt()
            if(num - 1 != 0){
                minCount?.invoke(listData[position])
                holder.binding.number.text="${num-1}"
            }
        }
        holder.binding.btnPlus.setOnClickListener {
            plusCount?.invoke(listData[position])
            holder.binding.number.text="${1+holder.binding.number.text.toString().toInt()}"
        }
        holder.binding.deleteCart.setOnClickListener{
            dbFood = FoodDatabase.getInstance(it.context)
            GlobalScope.async {
                SetViewModel(Application()).deleteFood(listData[position])
                dbFood?.roomDao()?.deleteData(listData[position])
                Navigation.findNavController(it).navigate(R.id.fragmentCart)
            }
        }
    }
    fun setData(listData: ArrayList<RoomEntity>){
        this.listData=listData
        notifyDataSetChanged()
    }
}