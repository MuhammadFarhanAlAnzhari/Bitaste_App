package com.aplikasi.bitasteapp.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RoomDAO {
    @Insert
    fun insertData(data: RoomEntity)
    @Delete
    fun deleteData(data: RoomEntity)
    @Query("SELECT * FROM food")
    fun getAllFood(): List<RoomEntity>
    @Query("SELECT SUM(harga) from food ")
    fun getTotalFood(): Int
    @Query("UPDATE food SET stock = :stock, harga = :harga WHERE id = :id ")
    fun updateStock(stock: Int, id: Int, harga: Int)
}