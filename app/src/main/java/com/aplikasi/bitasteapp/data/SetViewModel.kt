package com.aplikasi.bitasteapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aplikasi.bitasteapp.data.room.FoodDatabase
import com.aplikasi.bitasteapp.data.room.RoomEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SetViewModel (app: Application) : AndroidViewModel(app){
    private val dataFood : MutableLiveData<List<RoomEntity>> = MutableLiveData()


    fun getFoodObserver(): MutableLiveData<List<RoomEntity>> {
        return dataFood
    }
    fun getAllData() {
        dataFood.postValue(FoodDatabase.getInstance(getApplication())!!.roomDao().getAllFood())
    }

    fun deleteFood(roomEntity: RoomEntity) = GlobalScope.launch {
        val foodDB = FoodDatabase.getInstance(getApplication())!!.roomDao()
        foodDB.deleteData(roomEntity)
    }
    fun updateCount(stock: Int, id:Int, harga:Int){
        GlobalScope.launch {
            val user = FoodDatabase.getInstance(getApplication())!!.roomDao()
            user.updateStock(stock, id, harga)
        }
    }


    fun insertData(data: RoomEntity){
        GlobalScope.async {
            val user = FoodDatabase.getInstance(getApplication())!!.roomDao()
            user.insertData(data)
        }

    }
}